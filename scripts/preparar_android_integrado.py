from pathlib import Path
import re
import shutil
import tempfile
import zipfile

RAIZ = Path(__file__).resolve().parent.parent
ORIGEN = RAIZ / "Proyecto_Seguros_BPO-main (1).zip"
DESTINO = RAIZ / "android-integrado"
MARCADOR = ".generado-desde-mainotro"
SUPERPOSICION = RAIZ / "integracion-android" / "app"

def editar(archivo, anterior, nuevo):
    texto = archivo.read_text(encoding="utf-8")
    cantidad = texto.count(anterior)
    if cantidad != 1:
        raise RuntimeError(f"{archivo}: se esperaba una ocurrencia de {anterior[:70]!r}, hay {cantidad}")
    archivo.write_text(texto.replace(anterior, nuevo), encoding="utf-8")

def sustituir_patron(archivo, patron, reemplazo):
    texto = archivo.read_text(encoding="utf-8")
    nuevo, cantidad = re.subn(patron, lambda _: reemplazo, texto, count=1, flags=re.DOTALL)
    if cantidad != 1:
        raise RuntimeError(f"{archivo}: no se pudo insertar la integración")
    archivo.write_text(nuevo, encoding="utf-8")

def preparar():
    if DESTINO.exists() and not (DESTINO / MARCADOR).exists():
        raise RuntimeError("La carpeta android-integrado no fue generada por este script y no se reemplazará")
    if not ORIGEN.exists():
        raise FileNotFoundError(ORIGEN)

    with tempfile.TemporaryDirectory(prefix="seguros-bpo-") as temporal:
        temporal = Path(temporal)
        with zipfile.ZipFile(ORIGEN) as archivo:
            archivo.extractall(temporal)
        proyecto = temporal / "Proyecto_Seguros_BPO-main"
        if not (proyecto / "settings.gradle.kts").exists():
            raise RuntimeError("El ZIP del proyecto académico no contiene la raíz Android esperada")
        shutil.copytree(SUPERPOSICION, proyecto / "app", dirs_exist_ok=True)

        gradle = proyecto / "app" / "build.gradle.kts"
        editar(gradle, "    testImplementation(libs.junit)",
            '    implementation("com.squareup.retrofit2:retrofit:2.11.0")\n'
            '    implementation("com.squareup.retrofit2:converter-gson:2.11.0")\n'
            "    testImplementation(libs.junit)")

        manifest = proyecto / "app" / "src" / "main" / "AndroidManifest.xml"
        editar(manifest, '<uses-permission android:name="android.permission.CAMERA" />',
            '<uses-permission android:name="android.permission.INTERNET" />\n'
            '    <uses-permission android:name="android.permission.CAMERA" />')
        editar(manifest, "    <application",
            '    <application\n        android:usesCleartextTraffic="true"')

        kotlin = proyecto / "app" / "src" / "main" / "java" / "cl" / "duocuc" / "segurosbpo"
        rutas = kotlin / "navigation" / "Rutas.kt"
        editar(rutas,
            '    data object Reportar : Ruta("reportar")',
            '    data object Reportar : Ruta("reportar")\n'
            '    data object Servidor : Ruta("servidor")')

        navegacion = kotlin / "navigation" / "AppNavegacion.kt"
        editar(navegacion,
            'import cl.duocuc.segurosbpo.ui.screens.MisSiniestrosScreen',
            'import cl.duocuc.segurosbpo.ui.screens.MisSiniestrosScreen\n'
            'import cl.duocuc.segurosbpo.ui.screens.SiniestrosServidorScreen')
        editar(navegacion,
            '    val asegurado by siniestrosVm.asegurado.collectAsStateWithLifecycle()',
            '    val asegurado by siniestrosVm.asegurado.collectAsStateWithLifecycle()\n'
            '    val estadoServidor by siniestrosVm.estadoServidor.collectAsStateWithLifecycle()')
        editar(navegacion,
            '                if (sesion.rol == RolCuenta.ASEGURADO) {',
            '                if (sesion.rol == RolCuenta.ASEGURADO) {\n'
            '                    composable(Ruta.Servidor.ruta) {\n'
            '                        SiniestrosServidorScreen(\n'
            '                            asegurado = asegurado,\n'
            '                            estadoSincronizacion = estadoServidor,\n'
            '                            onVolver = { navController.navigateUp() }\n'
            '                        )\n'
            '                    }')
        sustituir_patron(navegacion,
            r'(?=                OpcionInferior\(\n                    texto = "Estadísticas",)',
            '                OpcionInferior(\n'
            '                    texto = "Servidor",\n'
            '                    icono = R.drawable.ic_seguir,\n'
            '                    seleccionada = rutaActual == Ruta.Servidor.ruta,\n'
            '                    onClick = { onNavegar(Ruta.Servidor.ruta) }\n'
            '                )\n')

        datos = kotlin / "data" / "SiniestroDbHelper.kt"
        sustituir_patron(datos,
            r"(?=    fun listar\(asegurado: Asegurado, busqueda: String = \"\")",
            '''    fun actualizarNumeroServidor(id: Long, numero: String): Boolean {
        require(Regex("""SIN-\d{2}-\d{6}""").matches(numero)) { "Número remoto inválido" }
        return writableDatabase.update(
            "siniestros",
            ContentValues().apply { put("numero", numero) },
            "id = ?",
            arrayOf(id.toString())
        ) == 1
    }

''')

        vm = kotlin / "viewmodel" / "SiniestrosViewModel.kt"
        editar(vm, 'import androidx.lifecycle.AndroidViewModel',
            'import androidx.lifecycle.AndroidViewModel\n'
            'import cl.duocuc.segurosbpo.data.remote.ServidorSiniestros')
        editar(vm, '    val asegurado = _asegurado.asStateFlow()',
            '    val asegurado = _asegurado.asStateFlow()\n'
            '    private val _estadoServidor = MutableStateFlow("")\n'
            '    val estadoServidor = _estadoServidor.asStateFlow()')
        sustituir_patron(vm,
            r"    fun registrar\(estado: FormularioUiState\): String \{.*?\n    \}\n\n(?=    fun obtener\()",
            '''    suspend fun registrar(estado: FormularioUiState): String {
        require(estado.asegurado == _asegurado.value) { "El asegurado seleccionado cambió" }
        val nuevo = db.registrar(estado)
        ultimoRegistrado = nuevo.id
        refrescar()
        refrescarAsignados()
        val respuesta = runCatching { ServidorSiniestros.reportar(estado) }
        val remoto = respuesta.getOrNull()
        if (remoto != null) {
            val guardado = runCatching {
                db.actualizarNumeroServidor(nuevo.id, remoto.numero)
            }.getOrDefault(false)
            if (guardado) {
                _estadoServidor.value = "Enviado al servidor: ${remoto.numero}"
                refrescar()
                return remoto.numero
            }
            _estadoServidor.value = "El servidor recibió ${remoto.numero}, pero no se pudo actualizar el número local"
        } else {
            _estadoServidor.value = "Caso guardado en este teléfono. Sin sincronización con el servidor."
        }
        return nuevo.numero
    }

''')

        formulario = kotlin / "ui" / "screens" / "FormularioScreen.kt"
        texto = formulario.read_text(encoding="utf-8")
        ocurrencias = texto.count("onRegistroExitoso: (FormularioUiState) -> String")
        if ocurrencias != 2:
            raise RuntimeError(f"Se esperaban dos firmas del formulario, encontradas: {ocurrencias}")
        texto = texto.replace("onRegistroExitoso: (FormularioUiState) -> String",
                              "onRegistroExitoso: suspend (FormularioUiState) -> String")
        formulario.write_text(texto, encoding="utf-8")
        sustituir_patron(formulario,
            r"    fun registrarReporte\(\) \{.*?\n    \}\n(?=    if \(duplicado != null\))",
            '''    var registrando by remember { mutableStateOf(false) }
    fun registrarReporte() {
        if (registrando || viewModel.uiState.value.reporteExitoso) return
        registrando = true
        val estado = viewModel.uiState.value
        alcance.launch {
            try {
                val resultado = runCatching { onRegistroExitoso(estado) }
                resultado.onSuccess { numero ->
                    viewModel.confirmarRegistro(numero)
                    enviarAdjuntos()
                }.onFailure { errorEnvio = it.message ?: "No se pudo registrar el siniestro" }
            } finally {
                registrando = false
            }
        }
    }
''')

        (proyecto / MARCADOR).write_text("Generado desde Nicricht-mainOtro y superposición Retrofit\n", encoding="utf-8")
        if DESTINO.exists():
            shutil.rmtree(DESTINO)
        shutil.copytree(proyecto, DESTINO)

    print("Android integrado preparado: " + str(DESTINO))
    print("Abrir android-integrado en Android Studio para ejecutar la app conectada al backend Java")

if __name__ == "__main__":
    preparar()

# Integración académica Seguros BPO: Android Kotlin + Java Spring Boot

## Código fuente y preservación

- La aplicación originalmente validada se conserva sin cambios en `Proyecto_Seguros_BPO-main (1).zip`.
- `backend-java/` contiene los servicios `catalogos-service` (8081), `siniestros-service` (8082) y el `api-gateway` (8080).
- `integracion-android/` contiene las clases Retrofit y la pantalla Android para consultar los siniestros del backend.
- `scripts/preparar_android_integrado.py` genera `android-integrado/` aplicando la integración al contenido del ZIP original. No sobrescribe el ZIP.
- La carpeta `android-integrado/` se genera localmente y no debe incluirse en los commits.

## Ejecutar en Windows PowerShell

Desde la raíz del repositorio:

```powershell
py scripts/preparar_android_integrado.py
cd backend-java
docker compose up --build -d --wait
cd ..
```

Después, abrir la carpeta `android-integrado` en Android Studio y ejecutar la app en un **emulador Android**.

La app utiliza `http://10.0.2.2:8080/api/v1/` para acceder al Gateway que corre en el computador. Esa dirección es especial del emulador; no equivale al servidor de un teléfono físico. La conexión de desarrollo usa HTTP y datos ficticios; no publicar este entorno en Internet.

## Qué sucede en Android

1. Al registrar un siniestro desde el formulario, los datos se conservan localmente.
2. Retrofit intenta reportar el mismo siniestro al backend REST usando los encabezados de identidad ficticia `X-Role` y `X-Actor-Id`.
3. Si el backend responde, se actualiza el número del registro local al número entregado por el servidor y se informa la sincronización.
4. Si el backend no responde, se conserva el registro local y se informa que no quedó sincronizado. No hay reintento automático de esta primera versión.
5. La pestaña **Servidor** permite consultar desde el backend los siniestros del asegurado activo y revisar su historial.

La pantalla de servidor carga datos compartidos; las restantes pantallas de la aplicación original continúan trabajando con SQLite local. **No se ha implementado sincronización bidireccional completa** de todos los módulos, documentos, cambios de etapa y notificaciones. Esa diferencia no debe ocultarse al presentar el proyecto.

## Pruebas disponibles

```powershell
cd backend-java
mvn clean verify
docker compose up --build -d --wait
bash scripts/docker-smoke.sh
bash scripts/docker-e2e.sh
```

Para Android:

```powershell
cd android-integrado
.\gradlew.bat :app:assembleDebug :app:testDebugUnitTest
```

GitHub Actions `Android Java Integracion` genera la APK y corre pruebas unitarias de Android y Java y pruebas HTTP a través del Gateway. Las pruebas del backend y la compilación de Android por separado **no son una prueba instrumentada de teléfono real contra el servidor**. Esa validación requiere ejecutar el emulador con el backend disponible y verificar el recorrido completo desde la interfaz.

## Alcance docente

El proyecto del profesor sirve de referencia para Kotlin, Retrofit y consumo de API REST, no para copiar pantallas ni lógica. Para esta integración se reutiliza la aplicación de Seguros BPO, los dos microservicios existentes y un Gateway. Las pruebas unitarias no se reducen automáticamente a 18: ese número aparece en los anexos como total de requerimientos funcionales (12 obligatorios y 6 deseables).

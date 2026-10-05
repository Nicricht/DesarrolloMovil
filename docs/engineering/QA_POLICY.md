# Política de QA

Esta política define cómo se prueba el proyecto SeguimientoSiniestros. Se basa en las reglas de calidad usadas en RecepVoz, adaptadas al alcance académico, Android, Room, Retrofit y Spring Boot.

## 1. Responsabilidad de QA

Quien implementa un cambio también es responsable de demostrar que funciona.

Antes de implementar se debe:

1. clasificar el riesgo como LOW, MEDIUM o HIGH;
2. identificar los comportamientos que pueden fallar;
3. seleccionar el nivel de prueba más barato que realmente demuestre cada comportamiento;
4. considerar errores, límites y casos adversos importantes;
5. usar RED → GREEN para bugs reproducibles y comportamiento nuevo cuando aplique;
6. certificar siempre el commit final exacto.

Compilar, ver una pantalla correcta o probar manualmente una vez no es suficiente para declarar una tarea terminada.

## 2. Matriz de pruebas

| Cambio o riesgo | Evidencia esperada |
| --- | --- |
| Mapper, parser, cálculo o validación aislada | Unit tests con casos normales, límites y ramas relevantes |
| ViewModel o regla de presentación | Unit tests de estado, éxito y error |
| Room, DAO, SQLite o Repository local | Prueba instrumentada en emulador con Room real |
| Retrofit, DTO o API externa | Unit/contract tests con respuestas válidas, errores y JSON relevante |
| Spring Boot Controller/Service | Unit o integración según la dependencia real |
| Endpoint REST | Integración verificando status, cuerpo y errores principales |
| Formulario Compose | Pruebas de validación y UI cuando el comportamiento lo justifique |
| Recurso del dispositivo | Instrumented/UI test cuando sea posible y prueba manual documentada cuando dependa del hardware |
| Flujo visible de varias capas | E2E cuando pueda fallar entre UI, API, backend y persistencia |
| Bug reproducible | Prueba de regresión que falle antes del arreglo cuando sea viable |

Se usa el nivel más bajo que pruebe correctamente el comportamiento. No se hace E2E para getters o DTOs triviales.

## 3. Unit tests

Deben ser rápidos, deterministas y probar comportamiento.

Se deben cubrir:

- happy path;
- ramas relevantes;
- valores vacíos o inválidos cuando correspondan;
- límites;
- estados de error importantes.

Los mocks sirven para límites, pero un mock de Room o Spring Boot no demuestra el comportamiento real de esos componentes.

## 4. Room e integración Android

Cuando el comportamiento dependa de Room, DAO, relaciones o consultas:

- usar Room real en memoria;
- ejecutar la prueba como instrumented test;
- ejecutar la suite en un emulador Android desde CI;
- verificar resultados y no solo que no exista excepción.

## 5. Retrofit y contratos REST

Para cambios de Retrofit o del contrato:

- validar ruta y método HTTP;
- validar deserialización;
- validar respuestas de error relevantes;
- validar mapeo DTO → dominio;
- no considerar un MockWebServer como prueba de Spring Boot real.

Cuando exista backend disponible, el happy path principal debe tener una prueba E2E contra Spring Boot real.

## 6. Spring Boot

El backend debe tener pruebas para sus funciones principales.

Como mínimo, cuando aplique:

- respuesta 200 de consulta válida;
- 404 para recurso inexistente;
- datos esperados;
- historial y orden;
- validaciones;
- errores de entrada relevantes.

Si se incorpora persistencia de servidor, las pruebas deben usar la tecnología real necesaria para demostrar su comportamiento.

## 7. Casos adversos

Para cambios MEDIUM/HIGH se deben revisar los casos que realmente puedan romper la funcionalidad, por ejemplo:

- null, vacío o formato incorrecto;
- entrada repetida;
- falta de red;
- respuesta 4xx/5xx;
- JSON incompleto o inválido;
- datos locales antiguos;
- permisos rechazados;
- archivo no seleccionado;
- cámara cancelada;
- operación repetida.

No se prueban todos mecánicamente. Se eligen los que puedan romper la regla afectada.

## 8. Regresión

Todo bug reproducible que se corrija debe ganar una prueba de regresión en el nivel más bajo que reproduzca el defecto, cuando sea técnicamente posible.

No cuenta como solución:

- borrar la prueba;
- saltarla;
- debilitar el assert;
- cambiarla para que deje de verificar el error real.

## 9. Cobertura

La cobertura es una señal estructural y no demuestra por sí sola que las pruebas sean buenas.

Piso automático para código ejecutable nuevo o modificado:

- **Lines >= 80%**;
- **Branches >= 70%** cuando existan ramas.

Para lógica HIGH nueva o modificada, el objetivo de ingeniería es:

- **Lines significativas 100%**;
- **Branches significativas 100%**;
- **Methods significativos 100%**.

No se crean pruebas sin comportamiento solo para alcanzar números.

El código histórico sigue una regla de mejora: si se toca una zona poco probada, su protección debe mejorar.

## 10. E2E y happy path

El E2E protege los recorridos donde un error puede aparecer únicamente por la interacción entre varias capas.

Happy path principal actual:

```text
Inicio
  ↓
Consultar siniestro
  ↓
SIN-2026-001
  ↓
Retrofit
  ↓
Spring Boot
  ↓
Repository
  ↓
Room
  ↓
Detalle
  ↓
Historial
```

Este flujo debe permanecer verde cuando el backend esté integrado.

## 11. Fast Gate

Se usa mientras se desarrolla.

Debe:

- revisar el contrato QA;
- detectar archivos cambiados;
- compilar y ejecutar pruebas rápidas aplicables;
- generar cobertura;
- comprobar cobertura diferencial.

No reemplaza el Full Gate.

## 12. Full Gate

Antes de mergear una implementación:

- APK debug compila;
- unit tests Android pasan;
- reporte JaCoCo se genera;
- cobertura diferencial cumple;
- backend compila y sus pruebas pasan cuando existe;
- pruebas instrumentadas pasan en emulador mediante CI;
- E2E aplicable pasa.

## 13. HEAD exacto

La evidencia pertenece al commit que se probó.

Si después de un CI verde se modifica código o el contrato de ingeniería, se debe volver a certificar.

No se puede usar un CI verde de un commit anterior para justificar un HEAD distinto.

## 14. Definition of Done

Una tarea está terminada solo si:

- criterios de aceptación cumplidos;
- pruebas del nivel correcto creadas;
- regresiones cubiertas cuando corresponda;
- Fast Gate verde;
- Full Gate verde;
- cobertura aplicable cumplida;
- no quedan errores importantes conocidos;
- documentación actualizada si cambió el sistema;
- PR corresponde al HEAD certificado;
- Trello refleja el estado real;
- no se atribuye trabajo a otro integrante si no lo realizó.

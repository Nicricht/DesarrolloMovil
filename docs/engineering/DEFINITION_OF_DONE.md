# Definition of Done

Una tarea no está terminada porque exista código o porque compile.

Para marcar una tarea como completada deben cumplirse los puntos que correspondan:

- los criterios de aceptación están cumplidos;
- las pruebas apropiadas existen y pasan;
- cada bug reproducible corregido tiene prueba de regresión cuando es viable;
- unit, integration, instrumented y E2E pasan según el riesgo;
- la cobertura diferencial cumple el piso definido;
- Fast Gate está verde;
- Full Gate está verde;
- la evidencia corresponde al commit final exacto;
- si hubo cambios después del último CI verde, se volvió a ejecutar la certificación;
- `DOCUMENTACION.md` y docs relacionados están actualizados;
- el PR describe qué se probó;
- Trello refleja el estado real;
- no quedan bloqueos críticos escondidos;
- `main` no se modifica hasta el ciclo de release.

No se acepta como evidencia “debería funcionar”, una ejecución vieja o una prueba que no corresponda al código final.

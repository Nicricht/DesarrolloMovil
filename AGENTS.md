# Reglas de desarrollo y calidad

Estas reglas son obligatorias para cualquier cambio de implementación en este repositorio.

El proyecto usa una versión adaptada del enfoque de QA utilizado en RecepVoz: primero se entiende el impacto, después se implementa la solución más pequeña que cumpla el caso y la pauta, y finalmente se certifica el commit exacto que se quiere integrar.

## Antes de programar

1. Revisar el caso, la pauta disponible, `DOCUMENTACION.md` y la tarjeta de Trello.
2. Clasificar el cambio como LOW, MEDIUM o HIGH.
3. Definir qué puede fallar y qué prueba demuestra cada comportamiento.
4. Para bugs reproducibles y comportamiento nuevo, usar RED → GREEN cuando sea técnicamente razonable.
5. No agregar complejidad que no aporte al caso o a la evaluación.

## Riesgo

- **LOW:** documentación, copy, estilos aislados o cambios sin lógica.
- **MEDIUM:** pantallas con estado, CRUD, ViewModel, Repository, Room, Retrofit, endpoints y reglas normales.
- **HIGH:** permisos sensibles, cámara/archivos, seguridad, migraciones destructivas, datos sensibles o integraciones que puedan generar efectos externos.

La cantidad de pruebas debe ser proporcional al riesgo.

## QA obligatorio

- Un cambio no está terminado solo porque compila.
- Un bug reproducible debe recibir una prueba de regresión cuando sea posible.
- Lógica nueva o modificada debe tener pruebas enfocadas.
- Room/DAO/Repository debe probarse en Android real o emulador cuando dependa del framework.
- Retrofit debe tener pruebas de contrato, errores y mapeo cuando corresponda.
- Spring Boot debe probar controladores/servicios y respuestas relevantes.
- Los flujos visibles importantes deben tener prueba E2E cuando el fallo solo pueda demostrarse correctamente de punta a punta.
- No se crean pruebas vacías ni assertions sin sentido para subir cobertura.

## Cobertura

La cobertura es una señal, no una prueba de calidad.

Piso automático para código ejecutable nuevo o modificado:

- líneas diferenciales: **>= 80%**;
- ramas diferenciales: **>= 70%** cuando existan ramas.

Para lógica HIGH nueva o modificada, el objetivo es:

- líneas significativas: **100%**;
- ramas significativas: **100%**;
- métodos significativos: **100%**.

No se puede afirmar 100% de cobertura si el reporte no lo demuestra.

## Flujo obligatorio

```text
Trello
  ↓
rama dedicada
  ↓
RED cuando aplica
  ↓
implementación
  ↓
Fast Gate
  ↓
revisión adversarial
  ↓
Full Gate
  ↓
PR con HEAD exacto verde
  ↓
develop
  ↓
CI nuevamente sobre develop
```

Nunca se desarrolla directamente en `main`.

Nunca se mergea un PR rojo o con pruebas obligatorias pendientes.

Si cambia código después de una certificación, esa certificación queda obsoleta y se debe ejecutar nuevamente.

## Comandos

Fast Gate:

```bash
bash scripts/ci/fast-gate.sh <base-sha>
```

Full Gate:

```bash
bash scripts/ci/full-gate.sh <base-sha>
```

Las pruebas instrumentadas Android se ejecutan en el emulador de GitHub Actions como parte del Quality Gate.

## Definition of Done

Una tarea solo se considera terminada cuando cumple `docs/engineering/DEFINITION_OF_DONE.md` y la política `docs/engineering/QA_POLICY.md`.

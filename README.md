# Desarrollo de Aplicaciones Móviles · DSY1105

## Caso del proyecto

**Seguimiento móvil del estado de siniestros para clientes de servicios BPO**

Organización: **Servicios Corporativos Andes SpA**

Este repositorio contiene el desarrollo académico de la asignatura DSY1105. El desafío consiste en construir un MVP móvil para que clientes de servicios BPO asociados al rubro asegurador puedan consultar y hacer seguimiento del estado de sus siniestros.

## Base actual de desarrollo

Desde el **2 de octubre de 2026**, el desarrollo parte desde el proyecto Android Studio `SeguimientoSiniestros`:

- package: `com.example.seguimientosiniestros`
- Minimum SDK: API 24
- Jetpack Compose
- Material Design 3
- Kotlin DSL
- Empty Activity como punto de partida

Las funcionalidades se implementan desde esta base siguiendo las tareas y responsables definidos en Trello.

## Referencia de clase del profesor

Se conserva una copia limpia del proyecto Android **Miregistro** utilizado como referencia durante las clases:

**[referencias/profesor/Miregistro](./referencias/profesor/Miregistro/README.md)**

Esta referencia sirve para observar patrones de organización, recursos, temas, estilos y componentes reutilizables en Jetpack Compose. No reemplaza la pauta, el caso oficial ni `DOCUMENTACION.md`, y no forma parte de la compilación de la aplicación principal.

## 📘 Documentación oficial del proyecto

La fuente oficial y actualizada del proyecto es:

**[DOCUMENTACION.md](./DOCUMENTACION.md)**

Este archivo debe mantenerse sincronizado con el desarrollo. Cuando cambie el alcance, un requisito, una decisión técnica, la arquitectura, los modelos, las pantallas, la API o el estado de implementación, también debe actualizarse `DOCUMENTACION.md`.

La documentación distingue entre:

- requisitos del caso oficial,
- requisitos derivados,
- requisitos o ajustes definidos por la rúbrica,
- decisiones técnicas del equipo,
- funcionalidades implementadas,
- funcionalidades pendientes.

> GitHub es la fuente oficial de la documentación. Herramientas de comunicación como Discord pueden utilizarse para coordinación o avisos, pero no reemplazan la documentación versionada en este repositorio.

### Alcance principal

- Registrar o consultar un siniestro según el alcance definitivo del caso y la rúbrica.
- Adjuntar evidencia o documentación.
- Revisar estado e historial de gestiones.
- Recibir notificaciones ante cambios relevantes.
- Uso principal en teléfonos Android.
- Datos ficticios, sintéticos o anonimizados.

### Tecnologías exigidas por el caso

**Frontend móvil**
- Kotlin
- Android Studio
- Jetpack Compose
- Material Design 3
- Arquitectura MVVM
- Room / SQLite
- Retrofit

**Backend**
- Spring Boot
- API REST
- Microservicios
- Pruebas unitarias

## Documentación técnica complementaria

Los documentos de la carpeta `docs/` amplían temas específicos, pero deben mantenerse coherentes con `DOCUMENTACION.md`.

1. [Documentación maestra histórica](./docs/DOCUMENTACION_MAESTRA.md)
2. [Visión y alcance](./docs/00_VISION_Y_ALCANCE.md)
3. [Arquitectura](./docs/01_ARQUITECTURA.md)
4. [Diseño funcional y UX](./docs/02_DISENO_FUNCIONAL_Y_UX.md)
5. [Modelo de datos](./docs/03_MODELO_DE_DATOS.md)
6. [Contrato API REST](./docs/04_CONTRATO_API_REST.md)
7. [Plan de implementación](./docs/05_PLAN_DE_IMPLEMENTACION.md)
8. [Casos de uso](./docs/06_CASOS_DE_USO.md)
9. [Decisiones técnicas](./docs/07_DECISIONES_TECNICAS.md)
10. [Mockups funcionales](./docs/08_MOCKUPS_FUNCIONALES.md)

## Documento original del caso

Consulta [CASO_DSY1105_SEGUROS_BPO.md](./CASO_DSY1105_SEGUROS_BPO.md) para revisar el caso académico en formato Markdown.

## Regla de actualización

El flujo documental del proyecto es:

```text
Cambio en código o alcance
        ↓
Revisar impacto en DOCUMENTACION.md
        ↓
Actualizar documentación si corresponde
        ↓
Pull Request
        ↓
Revisión
        ↓
develop
```

Una tarea que cambie el comportamiento o la estructura relevante del sistema no se considera completamente terminada si la documentación quedó desactualizada.

## Flujo principal del MVP

```text
Cliente
  ↓
App Android
  ↓
Consulta siniestro
  ↓
Retrofit
  ↓
API REST / Spring Boot
  ↓
Estado + historial
  ↓
Room / SQLite
  ↓
Interfaz Compose
```

El objetivo es completar este recorrido de punta a punta antes de agregar funciones que no sean necesarias para el caso o la rúbrica.

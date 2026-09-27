# Desarrollo de Aplicaciones Móviles · DSY1105

## Caso del proyecto

**Seguimiento móvil del estado de siniestros para clientes de servicios BPO**

Organización: **Servicios Corporativos Andes SpA**

Este repositorio contiene el caso académico de la asignatura DSY1105. El desafío consiste en desarrollar una propuesta tecnológica materializada en un MVP móvil para que clientes de servicios BPO asociados al rubro asegurador puedan consultar y hacer seguimiento del estado de sus siniestros.

### Alcance principal

- Registrar o consultar un siniestro.
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

## Documentación del proyecto

La planificación inicial está organizada en los siguientes documentos:

1. [Visión y alcance](./docs/00_VISION_Y_ALCANCE.md)
2. [Arquitectura](./docs/01_ARQUITECTURA.md)
3. [Diseño funcional y UX](./docs/02_DISENO_FUNCIONAL_Y_UX.md)
4. [Modelo de datos](./docs/03_MODELO_DE_DATOS.md)
5. [Contrato API REST](./docs/04_CONTRATO_API_REST.md)
6. [Plan de implementación](./docs/05_PLAN_DE_IMPLEMENTACION.md)

## Documento original del caso

Consulta [CASO_DSY1105_SEGUROS_BPO.md](./CASO_DSY1105_SEGUROS_BPO.md) para ver el caso académico organizado en formato Markdown.

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

El objetivo inicial es que este flujo funcione de punta a punta antes de agregar funciones secundarias.

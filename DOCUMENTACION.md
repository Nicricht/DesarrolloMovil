# Documentación

## Proyecto

**Asignatura:** DSY1105 Desarrollo de Aplicaciones Móviles  
**Proyecto:** Seguimiento móvil del estado de siniestros para clientes de servicios BPO  
**Organización del caso:** Servicios Corporativos Andes SpA  
**Tipo de solución:** MVP académico Android  
**Documento base:** Caso oficial DSY1105  
**Estado:** Documento vivo y fuente oficial del proyecto

---

# 1. Propósito

Este documento es la **fuente oficial de verdad del proyecto** dentro del repositorio GitHub.

Reúne los requerimientos funcionales y no funcionales del sistema, las decisiones relevantes de alcance y el estado real de implementación.

Cuando un cambio afecte alguno de estos elementos, este archivo debe actualizarse junto con el desarrollo:

- alcance del MVP,
- requerimientos funcionales,
- requerimientos no funcionales,
- arquitectura,
- tecnologías,
- modelos de datos,
- pantallas y navegación,
- API,
- persistencia,
- integraciones,
- pruebas,
- decisiones técnicas importantes,
- estado de implementación.

Los documentos ubicados en la carpeta `docs/` son complementarios. Si existiera una contradicción entre un documento complementario y este archivo, se debe revisar y corregir la inconsistencia para que `DOCUMENTACION.md` represente el estado vigente del proyecto.

GitHub es el lugar oficial donde se mantiene esta documentación versionada. Herramientas de comunicación como Discord pueden utilizarse para coordinación, avisos o conversación del equipo, pero no reemplazan la documentación del repositorio.

## 1.1 Regla de actualización

El flujo de trabajo será:

```text
Cambio de código, alcance o decisión
        ↓
Revisar impacto documental
        ↓
Actualizar DOCUMENTACION.md si corresponde
        ↓
Pull Request
        ↓
Revisión
        ↓
develop
```

Una tarea que cambie de forma relevante el sistema no se considera completamente cerrada si la documentación correspondiente quedó desactualizada.

## 1.2 Clasificación del origen

Se distinguen los siguientes tipos de origen:

- **Caso oficial:** aparece de forma explícita en el caso DSY1105.
- **Derivado del caso:** se incorpora porque es necesario para implementar correctamente una tarea descrita en el caso.
- **Rúbrica:** requisito o ajuste definido por la pauta oficial cuando esté disponible.
- **Decisión técnica:** elección del equipo para implementar el sistema sin alterar el objetivo del caso.

Los requerimientos describen el objetivo final del MVP. Que un requisito aparezca en este documento no significa necesariamente que ya esté implementado.

## 1.3 Base canónica actual

Desde el **2 de octubre de 2026**, la base oficial de desarrollo es el proyecto Android Studio **SeguimientoSiniestros** entregado por el equipo y subido al repositorio.

Configuración base:

- nombre del proyecto: `SeguimientoSiniestros`,
- package/applicationId: `com.example.seguimientosiniestros`,
- Minimum SDK: API 24,
- Target SDK: 36,
- Jetpack Compose,
- Material Design 3,
- Kotlin,
- Kotlin DSL,
- Gradle Wrapper 9.4.1.

La base parte desde una **Empty Activity** y será desarrollada desde este punto siguiendo las tareas vigentes en Trello.

Las implementaciones funcionales anteriores permanecen disponibles en el historial Git, pero **ya no representan el estado actual del código**. Las funcionalidades de consulta, detalle, seguimiento, historial, MVVM, navegación y modelos deberán reimplementarse sobre esta base cuando corresponda según el sprint.

## 1.4 Referencia de trabajo utilizada en clases

El repositorio conserva el proyecto **Miregistro** como referencia académica en `referencias/profesor/Miregistro/`.

Esta referencia se utilizará para observar la forma de organización mostrada en clases, especialmente:

- separación de `ui/theme`, `ui/styles` y `ui/components`,
- dimensiones y estilos reutilizables,
- recursos gráficos y strings,
- uso de Jetpack Compose y Material Design 3,
- estructura general de un proyecto Android Studio.

La referencia **no define requerimientos funcionales del proyecto de siniestros**. Ante cualquier diferencia, la prioridad continúa siendo: pauta/rúbrica oficial, caso DSY1105 y esta documentación vigente.

---

# 2. Descripción general

El proyecto busca resolver la falta de visibilidad del cliente sobre el estado de su siniestro y reducir la dependencia de canales manuales como teléfono, correo u oficina.

La solución consiste en un MVP móvil Android que permita al cliente consultar y hacer seguimiento de un siniestro, revisar su estado e historial, adjuntar evidencia y recibir notificaciones ante cambios relevantes.

El sistema trabajará únicamente con datos ficticios, sintéticos o anonimizados.

---

# 3. Requerimientos funcionales

Los requerimientos funcionales representan acciones o comportamientos que el sistema debe ofrecer al usuario.

## RF-01. Consultar un siniestro

**Origen:** Caso oficial  
**Estado actual:** Pendiente de reimplementación sobre la nueva base canónica.

El sistema debe permitir que el cliente consulte un siniestro utilizando un identificador ficticio.

### Criterios de aceptación

- El usuario puede ingresar un identificador.
- El sistema busca el siniestro correspondiente.
- Si existe, muestra su información.
- Si no existe, informa el resultado de forma clara.

---

## RF-02. Registrar un siniestro

**Origen:** Caso oficial, alcance exacto pendiente de rúbrica.  
**Estado actual:** Pendiente.

El caso establece que las tareas del cliente consideran **registrar o consultar un siniestro**.

Por esta razón, el proyecto contempla el registro de un siniestro como parte del alcance posible, pero no se asumirá un flujo de registro completo hasta revisar la rúbrica oficial.

En caso de implementarse, utilizará únicamente información ficticia como:

- tipo de siniestro,
- fecha de ocurrencia,
- fecha de reporte,
- identificador ficticio.

---

## RF-03. Visualizar el detalle del siniestro

**Origen:** Derivado del caso.  
**Estado actual:** Pendiente de reimplementación sobre la nueva base canónica.

Una vez consultado un siniestro, el sistema debe presentar la información necesaria para comprender el caso.

La información considerada es:

- identificador,
- tipo de siniestro,
- fecha de ocurrencia,
- fecha de reporte,
- estado actual,
- equipo o colaborador asignado de forma referencial,
- última actualización cuando esté disponible.

---

## RF-04. Visualizar el estado y la etapa del siniestro

**Origen:** Caso oficial.  
**Estado actual:** Pendiente de reimplementación sobre la nueva base canónica.

El sistema debe permitir que el cliente identifique claramente el estado actual de su siniestro.

Los estados definidos por el caso son:

1. Recibido.
2. En evaluación.
3. En liquidación.
4. Cerrado.

---

## RF-05. Consultar el historial de gestiones

**Origen:** Caso oficial.  
**Estado actual:** Pendiente de reimplementación sobre la nueva base canónica.

El sistema debe permitir revisar el historial de gestiones realizadas sobre el siniestro.

Cada gestión puede mostrar:

- fecha y hora,
- descripción,
- estado resultante.

El historial debe mostrarse de manera ordenada y comprensible.

---

## RF-06. Adjuntar evidencia o documentación

**Origen:** Caso oficial.  
**Estado actual:** Pendiente.

El cliente debe poder adjuntar evidencia o documentación de respaldo asociada a su siniestro.

La solución debe contemplar:

- imágenes,
- documentos PDF sintéticos,
- uso de cámara cuando corresponda.

No se utilizarán archivos personales reales durante el desarrollo, las pruebas ni la demostración.

---

## RF-07. Consultar las evidencias asociadas

**Origen:** Derivado del caso.  
**Estado actual:** Pendiente.

Para permitir una experiencia coherente después de adjuntar documentación, el sistema podrá mostrar las evidencias asociadas al siniestro.

Este requerimiento es derivado. El caso exige explícitamente adjuntar evidencia, pero no define una pantalla independiente de consulta de evidencias.

---

## RF-08. Recibir notificaciones ante cambios relevantes

**Origen:** Caso oficial.  
**Estado actual:** Pendiente.

El sistema debe informar al cliente cuando exista un cambio relevante en su siniestro.

Las notificaciones deben quedar relacionadas con el caso correspondiente.

El caso indica que debe considerarse el envío de notificaciones push ante cambios de estado. La implementación exacta de push se confirmará con la rúbrica oficial.

---

## RF-09. Reflejar cambios de estado en el seguimiento

**Origen:** Derivado del caso.  
**Estado actual:** Pendiente de integración con backend.

Cuando el estado de un siniestro cambie, la aplicación debe reflejar la nueva etapa y mantener la trazabilidad visible para el cliente.

La actualización debe quedar representada en el seguimiento y, cuando corresponda, en el historial y las notificaciones.

---

# 4. Requerimientos no funcionales

Los requerimientos no funcionales corresponden a restricciones técnicas, condiciones de calidad y características obligatorias de la solución.

## RNF-01. Plataforma Android

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

La aplicación móvil debe estar orientada a teléfonos Android.

---

## RNF-02. Kotlin

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

El frontend móvil debe desarrollarse utilizando Kotlin.

---

## RNF-03. Android Studio

**Origen:** Caso oficial  
**Estado actual:** Requisito de entorno del proyecto.

El proyecto debe ser compatible con el desarrollo y ejecución mediante Android Studio.

---

## RNF-04. Jetpack Compose

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

La interfaz de usuario debe implementarse utilizando Jetpack Compose.

---

## RNF-05. Material Design 3

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

La interfaz debe utilizar Material Design 3.

---

## RNF-06. Arquitectura MVVM

**Origen:** Caso oficial  
**Estado actual:** En implementación sobre la nueva base canónica.

La aplicación debe utilizar arquitectura MVVM para mantener separadas la interfaz, el estado y la lógica de presentación.

La estructura base ya incorpora modelos de dominio, contrato de Repository, `MainViewModel` y `MainUiState`. La conexión efectiva de las pantallas con el ViewModel se completará en las tareas siguientes del Sprint 3.

---

## RNF-07. Persistencia local con Room/SQLite

**Origen:** Caso oficial  
**Estado actual:** Pendiente.

El frontend móvil debe utilizar Room/SQLite para la persistencia local requerida por el MVP.

La interfaz de usuario no debe acceder directamente a la base de datos.

---

## RNF-08. Integración mediante Retrofit

**Origen:** Caso oficial  
**Estado actual:** Pendiente.

La aplicación Android debe integrarse con el backend mediante Retrofit.

Las llamadas remotas deben mantenerse fuera de la capa de interfaz.

---

## RNF-09. Backend Spring Boot

**Origen:** Caso oficial  
**Estado actual:** Pendiente.

El backend del MVP debe desarrollarse utilizando Spring Boot.

---

## RNF-10. API REST

**Origen:** Caso oficial  
**Estado actual:** Pendiente.

El backend debe exponer una API REST que entregue la información necesaria para el funcionamiento del MVP.

---

## RNF-11. Microservicios

**Origen:** Caso oficial  
**Estado actual:** Pendiente.

El backend requerido por el caso debe utilizar microservicios Spring Boot.

La cantidad de servicios se mantendrá acotada a las responsabilidades necesarias para el MVP académico, evitando complejidad que no aporte al caso ni a la evaluación.

---

## RNF-12. Pruebas unitarias del backend

**Origen:** Caso oficial  
**Estado actual:** Pendiente.

El backend debe incorporar pruebas unitarias para validar sus funciones principales.

---

## RNF-13. Usabilidad

**Origen:** Caso oficial  
**Estado actual:** En aplicación continua durante el desarrollo.

La experiencia debe considerar usuarios de distintas edades y distintos niveles de familiaridad tecnológica.

La aplicación debe ser:

- simple,
- clara,
- comprensible,
- de bajo esfuerzo cognitivo.

---

## RNF-14. Privacidad y protección de datos

**Origen:** Caso oficial  
**Estado actual:** Cumplido en los datos actuales del proyecto.

No se utilizarán datos personales reales de asegurados.

Tampoco se utilizarán:

- pólizas reales,
- información médica real,
- información financiera real,
- credenciales reales,
- accesos a sistemas internos.

---

## RNF-15. Seguridad

**Origen:** Caso oficial  
**Estado actual:** Requisito transversal.

La solución debe considerar buenas prácticas de seguridad y protección de datos personales.

---

## RNF-16. Datos ficticios, sintéticos o anonimizados

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

Todos los datos utilizados para desarrollo, pruebas y demostración deben ser ficticios, sintéticos o anonimizados.

---

## RNF-17. Sin integración productiva con sistemas core

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

El MVP no debe implementar integración productiva con sistemas core de pólizas ni con otros sistemas internos de aseguradoras.

La información externa será simulada mediante los componentes académicos desarrollados para el proyecto.

---

## RNF-18. Sin login real

**Origen:** Caso oficial  
**Estado actual:** Cumplido.

No se debe desarrollar un sistema de autenticación real para este MVP académico.

---

## RNF-19. Enfoque en happy path

**Origen:** Caso oficial  
**Estado actual:** Cumplido en la planificación actual.

El proyecto no necesita desarrollar todas las vistas ni todos los flujos excepcionales.

El desarrollo debe concentrarse primero en el recorrido principal necesario para demostrar la solución.

---

# 5. Matriz resumida de requerimientos

| Código | Requerimiento | Origen | Estado actual |
|---|---|---|---|
| RF-01 | Consultar siniestro | Caso oficial | Implementado |
| RF-02 | Registrar siniestro | Caso oficial, alcance a confirmar | Pendiente |
| RF-03 | Visualizar detalle | Derivado | Implementado |
| RF-04 | Visualizar estado y etapa | Caso oficial | Implementado |
| RF-05 | Consultar historial | Caso oficial | Implementado |
| RF-06 | Adjuntar evidencia/documentación | Caso oficial | Pendiente |
| RF-07 | Consultar evidencias | Derivado | Pendiente |
| RF-08 | Recibir notificaciones | Caso oficial | Pendiente |
| RF-09 | Reflejar cambios de estado | Derivado | Pendiente |
| RNF-01 | Android | Caso oficial | Cumplido |
| RNF-02 | Kotlin | Caso oficial | Cumplido |
| RNF-03 | Android Studio | Caso oficial | Requisito de entorno |
| RNF-04 | Jetpack Compose | Caso oficial | Cumplido |
| RNF-05 | Material Design 3 | Caso oficial | Cumplido |
| RNF-06 | MVVM | Caso oficial | Cumplido |
| RNF-07 | Room/SQLite | Caso oficial | Pendiente |
| RNF-08 | Retrofit | Caso oficial | Pendiente |
| RNF-09 | Spring Boot | Caso oficial | Pendiente |
| RNF-10 | API REST | Caso oficial | Pendiente |
| RNF-11 | Microservicios | Caso oficial | Pendiente |
| RNF-12 | Pruebas unitarias backend | Caso oficial | Pendiente |
| RNF-13 | Usabilidad | Caso oficial | En progreso |
| RNF-14 | Privacidad | Caso oficial | Cumplido actualmente |
| RNF-15 | Seguridad | Caso oficial | Transversal |
| RNF-16 | Datos ficticios | Caso oficial | Cumplido |
| RNF-17 | Sin integración core productiva | Caso oficial | Cumplido |
| RNF-18 | Sin login real | Caso oficial | Cumplido |
| RNF-19 | Happy path | Caso oficial | Cumplido |

---

# 6. Estado actual de implementación

## 6.1 Base implementada

Actualmente el repositorio contiene la nueva base canónica Android Studio:

- proyecto `SeguimientoSiniestros`,
- package `com.example.seguimientosiniestros`,
- Minimum SDK 24,
- Target SDK 36,
- Kotlin,
- Jetpack Compose,
- Material Design 3,
- tema Compose inicial,
- `MainActivity` generada como Empty Activity,
- Gradle Wrapper,
- pruebas de ejemplo generadas por Android Studio,
- CI preparado para compilar el APK y ejecutar pruebas unitarias,
- modelos de dominio `Siniestro`, `GestionHistorial`, `Evidencia` y `Notificacion`,
- enum `EstadoSiniestro` con los cuatro estados definidos por el caso,
- contrato `SiniestroRepository`,
- `MainUiState` y `MainViewModel` como base de presentación MVVM,
- navegación Compose con rutas para Inicio, Consulta, Detalle, Seguimiento, Historial, Evidencias y Notificaciones,
- pantallas base navegables para el happy path,
- sistema visual Compose reutilizable con `Dimens`, estilos de botones, campos y tarjetas,
- componentes compartidos `PantallaBase`, `BotonPrincipal`, `TarjetaInformativa` y `EstadoSiniestroChip`,
- tema visual propio aplicado a las pantallas base,
- pruebas unitarias de estados oficiales, construcción de rutas y orden de etapas.

La aplicación ya inicia en una navegación Compose básica y las pantallas Inicio, Consulta, Detalle, Seguimiento, Historial, Evidencias y Notificaciones comparten un sistema visual reutilizable. Todavía no consumen datos reales ni están conectadas al Repository.

## 6.2 Pendiente de reimplementación y desarrollo

A partir de esta base falta implementar:

- conectar las pantallas con el ViewModel y el Repository,
- consulta de siniestro,
- detalle del siniestro,
- seguimiento y estados,
- historial,
- Room/SQLite,
- backend Spring Boot,
- microservicios,
- API REST,
- Retrofit,
- evidencias con imágenes/PDF/cámara,
- notificaciones,
- actualización remota de estados,
- pruebas unitarias del backend,
- integración completa Android ↔ backend,
- definición final del registro de siniestro según la rúbrica.

Las tareas de implementación deben seguir el orden y los responsables definidos en Trello.

---

# 7. Relación con el problema del caso

La funcionalidad priorizada responde directamente al problema principal del caso: el cliente necesita conocer el estado de su siniestro sin depender de teléfono, correo u oficina.

El MVP debe contribuir a:

- dar mayor visibilidad del estado del caso,
- mejorar la trazabilidad percibida,
- facilitar el acceso a la información,
- reducir la dependencia de canales manuales,
- ofrecer una experiencia simple durante un proceso potencialmente estresante.

---

# 8. Fuera de alcance

El proyecto no contempla:

- login productivo,
- sistemas core reales de pólizas,
- información personal real,
- información médica o financiera real,
- credenciales reales,
- integración productiva con aseguradoras,
- implementación productiva de módulos internos de normalización o distribución,
- publicación productiva de la aplicación,
- cobertura completa de todos los flujos excepcionales.

---

# 9. Regla de alcance

Antes de incorporar una nueva funcionalidad se debe comprobar que:

1. la solicite el caso o la rúbrica,
2. aporte al happy path,
3. pueda demostrarse,
4. pueda probarse,
5. no agregue complejidad innecesaria.

Cuando esté disponible, la rúbrica oficial tendrá prioridad para definir el alcance final del proyecto.


---

# 10. Plan acelerado de sprints hasta la entrega

El plazo del proyecto se redujo a aproximadamente **una semana y media**. La planificación se organiza con trabajo paralelo y tareas pequeñas.

Mientras no exista una fecha oficial exacta, se utilizará como ventana interna tentativa el período **28 de septiembre al 7 de octubre de 2026**.

La prioridad es completar primero lo obligatorio del caso y evitar funcionalidades que no aporten al MVP o a la rúbrica.

## 10.0 Responsables asignados

- **Nicolás Iván Vega Linero:** GitHub `@Nicricht`, Trello `@nicolasivanvegalinero`. Responsable principal de Room, Retrofit y cambios de estado/notificaciones.
- **Colaborador del repositorio:** responsable principal de Spring Boot, endpoints, pruebas de backend, evidencias, UI/UX y microservicio de notificaciones.
- **Ambos:** integración, pruebas E2E, privacidad/seguridad, validación final, documentación de cierre y release.

## Sprint 0 · Documentación inicial

**Estado:** Completado.

Incluyó visión, alcance, requerimientos, arquitectura inicial, modelo de datos, contrato API, casos de uso, decisiones técnicas, mockups, GitFlow y documentación oficial.

## Sprint 1 · Base Android

**Estado histórico:** Completado en una implementación anterior.

El **2 de octubre de 2026** el equipo decidió reemplazar esa implementación por la nueva base canónica `SeguimientoSiniestros`. La experiencia previa se conserva en Git, pero el desarrollo vigente parte desde la nueva Empty Activity.

## Sprint 2 · Consulta y seguimiento local

**Estado histórico:** Completado en una implementación anterior.

La implementación previa de consulta y seguimiento quedó preservada en el historial Git, pero no forma parte de la nueva base actual. Las funcionalidades se reimplementarán según las tareas vigentes del Sprint 3.

## Sprint 3 · Room + Backend + Retrofit + Integración + Evidencias

**Ventana:** 28 de septiembre al 4 de octubre de 2026.  
**Estado:** Sprint actual.

Este sprint corresponde a la **unión de los antiguos Sprint 3 y Sprint 4**.

### Nicolás Iván Vega Linero

1. **A0.1 · Estructura MVVM y modelos de dominio** ✅
2. **A0.2 · Navegación y pantallas base** ✅
3. **A0.3 · Sistema visual reutilizable Compose** ✅
4. **A1 · Room: dependencias y entidades**
5. **A2 · Room: DAO y base de datos**
6. **A3 · Room: repositorio local y pruebas**
7. **A4 · Retrofit: configuración, DTOs y ApiService**
8. **A5 · Retrofit: repositorio remoto + ViewModel**

### Colaborador del repositorio

1. **B1 · Spring Boot base**
2. **B2 · Endpoint de consulta**
3. **B3 · Endpoint de historial**
4. **B4 · Pruebas unitarias y CI**
5. **B5 · Evidencia: selector de imagen y PDF**
6. **B6 · Evidencia: cámara y permisos**

### Ambos

1. **I1 · Integrar estado e historial con backend**
2. **I2 · Integrar Room + API**
3. **I3 · Prueba E2E consulta → historial**

### Criterio de cierre del Sprint 3

El Sprint 3 se considera terminado cuando:

- la nueva base cuenta con estructura MVVM, modelos, navegación y pantallas base,
- existe un sistema visual Compose reutilizable coherente con el trabajo desarrollado en clases,
- Room/SQLite funciona desde Repository,
- Spring Boot y los endpoints REST funcionan,
- Retrofit conecta Android con el backend,
- consulta, detalle, estado e historial funcionan de punta a punta,
- Room actúa como persistencia/cache simple,
- evidencia básica con imagen/PDF/cámara está disponible,
- pruebas principales pasan,
- `DOCUMENTACION.md` coincide con lo implementado.

**Fecha límite interna del Sprint 3: 4 de octubre de 2026.**

## Sprint 4 · Notificaciones + UI + calidad + pruebas

**Ventana:** 5 y 6 de octubre de 2026.

### Nicolás Iván Vega Linero

- cambio simulado de estado,
- generación de notificación,
- actualización del seguimiento.

### Colaborador del repositorio

- estados loading/error/empty,
- confirmaciones,
- consistencia Material Design 3,
- microservicio mínimo de notificaciones,
- prueba unitaria básica del servicio.

### Ambos

- revisión de privacidad y seguridad,
- pruebas Android + backend,
- verificación de datos ficticios,
- corrección de errores críticos.

### Registro de siniestro

El registro continúa como **tarea condicional**. Solo se implementará si la rúbrica confirma que debe desarrollarse además de la consulta.

## Sprint 5 · Cierre y entrega

**Ventana:** 7 de octubre de 2026.

Responsabilidad compartida.

Tareas:

- validar happy path completo,
- corregir errores críticos,
- actualizar `DOCUMENTACION.md`,
- revisar diagramas,
- preparar demostración,
- verificar README y enlaces,
- comprobar CI,
- preparar `release/*`,
- fusionar a `main` solo cuando `develop` esté estable.

## 10.1 Regla para el plazo reducido

El trabajo debe avanzar en paralelo:

```text
Nicolás ───── Room ── Retrofit ── Notificaciones ──┐
                                                   ├── Integración y entrega
Colaborador ── Backend ── Evidencias ── UI/UX ─────┘
```

Cada tarea debe ser suficientemente pequeña para poder completarse, probarse y fusionarse rápidamente.

## 10.2 Regla para trabajo en pareja

Cada tarea técnica debe definir sprint, responsable, rama Git, objetivo, subtareas, criterios de aceptación, pruebas necesarias e impacto en `DOCUMENTACION.md`.

El flujo sigue siendo:

```text
Tarea Trello
   ↓
rama feature/*, test/* o docs/*
   ↓
desarrollo
   ↓
pruebas
   ↓
actualizar DOCUMENTACION.md
   ↓
Pull Request
   ↓
develop
```

No se trabaja directamente sobre `main`.

# 11. Diagramas esenciales

Estos diagramas representan el alcance funcional y la arquitectura objetivo del MVP. Los componentes marcados como pendientes forman parte de los siguientes sprints y no deben interpretarse como ya implementados.

## 11.1 Diagrama de casos de uso

El actor principal del MVP móvil es el **cliente o asegurado**. El colaborador o liquidador y el equipo de administración forman parte del contexto del proceso, pero no requieren una aplicación administrativa completa dentro del alcance actual.

```mermaid
flowchart LR
    CLIENTE[Cliente / Asegurado]

    subgraph APP["MVP móvil de seguimiento de siniestros"]
        UC1((Consultar siniestro))
        UC2((Visualizar detalle))
        UC3((Ver estado y etapa))
        UC4((Consultar historial))
        UC5((Adjuntar evidencia))
        UC6((Consultar evidencias))
        UC7((Recibir notificaciones))
        UC8((Registrar siniestro))
    end

    CLIENTE --> UC1
    CLIENTE --> UC2
    CLIENTE --> UC3
    CLIENTE --> UC4
    CLIENTE --> UC5
    CLIENTE --> UC6
    CLIENTE --> UC7
    CLIENTE -. alcance por confirmar con rúbrica .-> UC8

    UC1 --> UC2
    UC2 --> UC3
    UC2 --> UC4
    UC2 --> UC5
```

**Estado actual:** consulta, detalle, estado e historial ya existen con datos ficticios locales. Evidencias y notificaciones están pendientes. El registro queda sujeto a la revisión de la rúbrica.

## 11.2 Diagrama de arquitectura general

La arquitectura objetivo respeta las tecnologías exigidas por el caso: Android con Kotlin, Compose, Material 3 y MVVM; persistencia local con Room/SQLite; integración mediante Retrofit; y backend con Spring Boot, API REST y microservicios.

```mermaid
flowchart TB
    USER[Cliente]

    subgraph ANDROID["Aplicación Android"]
        UI[Jetpack Compose + Material 3]
        VM[ViewModel]
        REPO[Repository]
        ROOM[(Room / SQLite)]
        RETROFIT[Retrofit]
    end

    subgraph BACKEND["Backend académico"]
        API[API REST]
        SIN[Microservicio de siniestros]
        NOTIF[Microservicio de notificaciones]
        DATA[(Datos ficticios)]
    end

    USER --> UI
    UI --> VM
    VM --> REPO
    REPO --> ROOM
    REPO --> RETROFIT
    RETROFIT --> API
    API --> SIN
    API --> NOTIF
    SIN --> DATA
    NOTIF --> DATA
```

**Estado actual de la arquitectura:**

- **Implementado:** UI Compose, Material 3, ViewModel, Repository y modelos de dominio.
- **Sprint 3:** Room/SQLite y backend Spring Boot/API REST.
- **Sprint 4:** Retrofit e integración remota.
- **Sprint 5:** notificaciones y actualización de estado.

## 11.3 Diagrama del modelo de datos

El modelo se mantiene limitado a la información necesaria para el caso académico y utiliza únicamente información ficticia.

```mermaid
erDiagram
    SINIESTRO ||--o{ GESTION_HISTORIAL : tiene
    SINIESTRO ||--o{ EVIDENCIA : contiene
    SINIESTRO ||--o{ NOTIFICACION : genera

    SINIESTRO {
        string id PK
        string tipo
        string fechaOcurrencia
        string fechaReporte
        string estado
        string equipoAsignado
        string ultimaActualizacion
    }

    GESTION_HISTORIAL {
        string id PK
        string siniestroId FK
        string fechaHora
        string descripcion
        string estadoResultante
    }

    EVIDENCIA {
        string id PK
        string siniestroId FK
        string nombreArchivo
        string tipoMime
        string uriLocal
        string urlRemota
        string fechaCarga
        string estadoCarga
    }

    NOTIFICACION {
        string id PK
        string siniestroId FK
        string titulo
        string mensaje
        string fechaHora
        boolean leida
    }
```

Los valores permitidos para el estado del siniestro son:

```text
RECIBIDO
EN_EVALUACION
EN_LIQUIDACION
CERRADO
```

## 11.4 Diagrama de secuencia de consulta

El siguiente diagrama muestra el flujo objetivo cuando Android ya esté conectado al backend. Actualmente la aplicación llega hasta el repositorio ficticio local. Room, Retrofit y Spring Boot se incorporan en Sprint 3 y Sprint 4.

```mermaid
sequenceDiagram
    actor Cliente
    participant UI as Compose UI
    participant VM as ViewModel
    participant Repo as Repository
    participant Api as Retrofit
    participant REST as API REST
    participant Backend as Spring Boot
    participant Room as Room/SQLite

    Cliente->>UI: Ingresa ID de siniestro
    UI->>VM: Buscar siniestro
    VM->>Repo: buscarPorId(id)
    Repo->>Api: GET /api/v1/siniestros/{id}
    Api->>REST: Solicitud HTTP
    REST->>Backend: Consultar siniestro ficticio
    Backend-->>REST: Siniestro + estado
    REST-->>Api: JSON
    Api-->>Repo: DTO
    Repo->>Room: Guardar/actualizar cache
    Repo-->>VM: Modelo de dominio
    VM-->>UI: Estado de pantalla
    UI-->>Cliente: Detalle y estado

    Cliente->>UI: Abre historial
    UI->>VM: Solicitar historial
    VM->>Repo: obtenerHistorial(id)
    Repo->>Api: GET /api/v1/siniestros/{id}/historial
    Api->>REST: Solicitud HTTP
    REST->>Backend: Consultar gestiones
    Backend-->>REST: Historial ficticio
    REST-->>Api: JSON
    Api-->>Repo: Lista de gestiones
    Repo->>Room: Guardar/actualizar historial
    Repo-->>VM: Historial
    VM-->>UI: Historial visible
    UI-->>Cliente: Gestiones del caso
```

## 11.5 Regla de mantenimiento de diagramas

Los diagramas forman parte de la documentación viva. Si cambia la arquitectura, el modelo de datos, los actores, el flujo de consulta o las responsabilidades de los componentes, estos diagramas deben actualizarse en el mismo ciclo de trabajo.

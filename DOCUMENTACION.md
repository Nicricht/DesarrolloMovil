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
**Estado actual:** Implementado con datos ficticios locales.

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
**Estado actual:** Implementado con datos ficticios locales.

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
**Estado actual:** Implementado con datos ficticios locales.

El sistema debe permitir que el cliente identifique claramente el estado actual de su siniestro.

Los estados definidos por el caso son:

1. Recibido.
2. En evaluación.
3. En liquidación.
4. Cerrado.

---

## RF-05. Consultar el historial de gestiones

**Origen:** Caso oficial.  
**Estado actual:** Implementado con datos ficticios locales.

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
**Estado actual:** Cumplido en la estructura Android actual.

La aplicación debe utilizar arquitectura MVVM para mantener separadas la interfaz, el estado y la lógica de presentación.

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

## 6.1 Implementado

Actualmente el proyecto contiene:

- proyecto Android base,
- Kotlin,
- Jetpack Compose,
- Material Design 3,
- arquitectura MVVM inicial,
- navegación entre pantallas,
- modelos principales del dominio,
- consulta de un siniestro ficticio,
- validación de identificador inexistente,
- visualización del detalle,
- visualización del estado,
- visualización del historial,
- datos ficticios locales,
- compilación automática del APK mediante integración continua.

El flujo funcional disponible actualmente es:

```text
Inicio
  ↓
Consultar SIN-2026-001
  ↓
Detalle
  ├── Seguimiento
  └── Historial
```

---

## 6.2 Pendiente

Todavía falta implementar:

- definición final del registro de siniestro según la rúbrica,
- Room/SQLite,
- backend Spring Boot,
- microservicios,
- API REST,
- Retrofit,
- evidencias con imágenes/PDF/cámara,
- notificaciones,
- actualización remota de estados,
- pruebas unitarias del backend,
- integración completa Android ↔ backend.

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

# 10. Plan de sprints hasta la entrega

La planificación se organiza considerando una entrega estimada durante la semana del **20 de octubre de 2026**. Las fechas son ventanas de trabajo sugeridas y deberán ajustarse cuando exista una fecha oficial de entrega.

La meta interna es llegar al **20 de octubre con el MVP terminado**, dejando la semana de entrega como margen para correcciones menores, revisión de la pauta y preparación final.

## Sprint 0 · Documentación inicial

**Estado:** Completado.

Incluyó:

- visión y alcance,
- requerimientos,
- arquitectura inicial,
- modelo de datos,
- contrato API inicial,
- casos de uso,
- decisiones técnicas,
- mockups,
- GitFlow,
- documentación oficial en GitHub.

## Sprint 1 · Base Android

**Estado:** Completado.

Incluyó:

- proyecto Android,
- Kotlin,
- Jetpack Compose,
- Material Design 3,
- estructura MVVM,
- navegación,
- modelos principales del dominio.

## Sprint 2 · Consulta y seguimiento local

**Estado:** Completado.

Incluyó:

- consulta de `SIN-2026-001`,
- validación de identificador inexistente,
- detalle del siniestro,
- estado y etapa,
- historial,
- repositorio ficticio local,
- integración con ViewModel.

## Sprint 3 · Backend, persistencia y diagramas

**Ventana sugerida:** 28 de septiembre al 4 de octubre.  
**Estado:** Sprint actual.

### Persona A

**Tarea:** Room/SQLite.

Debe implementar:

- dependencias Room,
- entidades locales para siniestro e historial,
- DAO,
- base de datos,
- repositorio local,
- integración con ViewModel sin acceso directo desde la UI.

### Persona B

**Tarea:** Spring Boot + API REST.

Debe implementar:

- proyecto Spring Boot,
- modelo y DTO de siniestro,
- `GET /api/v1/siniestros/{id}`,
- `GET /api/v1/siniestros/{id}/historial`,
- datos ficticios,
- manejo de identificador inexistente,
- pruebas unitarias principales.

### Equipo

Completar los diagramas mínimos necesarios:

- casos de uso,
- arquitectura general,
- modelo de datos,
- secuencia del flujo de consulta.

**Cierre del sprint:** Room funcionando, API funcionando, pruebas de backend pasando y documentación coherente.

## Sprint 4 · Integración remota y evidencias

**Ventana sugerida:** 5 al 11 de octubre.

### Persona A

**Tarea:** Retrofit e integración Android ↔ API.

Debe implementar:

- configuración Retrofit,
- DTOs,
- servicio API,
- mappers,
- repositorio remoto,
- integración con ViewModel,
- manejo básico de errores de red.

### Persona B

**Tarea:** Evidencias.

Debe implementar:

- selección de imagen,
- selección de PDF,
- uso de cámara cuando corresponda,
- asociación de evidencia al siniestro,
- permisos Android necesarios,
- confirmación de la acción.

### Equipo

Integrar:

```text
Consulta
  ↓
API REST
  ↓
Detalle
  ↓
Seguimiento
  ↓
Historial
```

**Cierre del sprint:** la consulta, el detalle, el estado y el historial funcionan contra Spring Boot.

## Sprint 5 · Notificaciones, calidad y pruebas

**Ventana sugerida:** 12 al 17 de octubre.

### Persona A

**Tarea:** Notificaciones y cambios de estado.

Debe implementar:

- cambio de estado simulado,
- notificación asociada,
- listado de notificaciones,
- navegación al siniestro relacionado,
- actualización del seguimiento.

### Persona B

**Tarea:** UI/UX y privacidad.

Debe revisar:

- jerarquía visual,
- textos,
- estados loading/success/empty/error,
- consistencia Material Design 3,
- accesibilidad básica,
- privacidad,
- uso exclusivo de datos ficticios.

### Equipo

Realizar pruebas de:

- ViewModel y repositorios,
- consulta válida e inválida,
- Retrofit ↔ API,
- Room ↔ Repository,
- navegación principal,
- flujo integrado.

### Registro de siniestro

El registro queda como **tarea condicional**. Solo se implementará en este sprint si la rúbrica confirma que es necesario desarrollar además de la consulta.

**Cierre del sprint:** funciones principales completas y errores críticos identificados.

## Sprint 6 · Cierre, validación y entrega

**Ventana sugerida:** 18 y 19 de octubre.

Responsabilidad compartida.

Tareas:

- probar el happy path completo,
- corregir errores críticos,
- actualizar `DOCUMENTACION.md`,
- revisar requisitos y diagramas,
- preparar recorrido de demostración,
- revisar README y enlaces,
- verificar CI,
- preparar release estable,
- integrar a `main` únicamente cuando `develop` esté validado.

El recorrido final esperado es:

```text
Abrir app
  ↓
Consultar siniestro
  ↓
Obtener información desde Spring Boot
  ↓
Ver detalle y estado
  ↓
Ver historial
  ↓
Adjuntar evidencia
  ↓
Simular cambio de estado
  ↓
Recibir notificación
  ↓
Ver estado actualizado
```

## 10.1 Regla para trabajo en pareja

Cada tarea técnica debe definir:

- sprint,
- responsable,
- rama Git,
- objetivo,
- subtareas,
- criterios de aceptación,
- dependencias,
- pruebas necesarias,
- impacto en `DOCUMENTACION.md`.

Las personas deben trabajar en ramas distintas siempre que sea posible para evitar modificar los mismos archivos al mismo tiempo.

El flujo esperado es:

```text
Tarea Trello
   ↓
feature/* o docs/*
   ↓
Desarrollo
   ↓
Pruebas
   ↓
Actualizar documentación si corresponde
   ↓
Pull Request
   ↓
Revisión
   ↓
develop
```

No se trabaja directamente sobre `main`.

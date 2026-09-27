# Documentación

## Proyecto

**Asignatura:** DSY1105 Desarrollo de Aplicaciones Móviles  
**Proyecto:** Seguimiento móvil del estado de siniestros para clientes de servicios BPO  
**Organización del caso:** Servicios Corporativos Andes SpA  
**Tipo de solución:** MVP académico Android

---

## 1. Descripción general

El proyecto consiste en desarrollar una aplicación móvil Android que permita a un cliente consultar y realizar seguimiento a un siniestro sin depender principalmente de llamadas telefónicas, correos electrónicos u otros canales manuales.

La solución debe permitir visualizar el estado del siniestro, revisar su historial, adjuntar evidencia y recibir avisos cuando existan cambios relevantes.

El sistema trabajará únicamente con datos ficticios, sintéticos o anonimizados.

---

# 2. Requerimientos funcionales

Los requerimientos funcionales describen las acciones que el sistema debe permitir realizar.

## RF-01. Consultar un siniestro

El sistema debe permitir que el usuario consulte un siniestro mediante un identificador.

### Criterios

- El usuario puede ingresar un identificador.
- El sistema busca el siniestro correspondiente.
- Si el siniestro existe, se muestra su información.
- Si no existe, se informa al usuario de forma clara.

---

## RF-02. Registrar un siniestro

El caso plantea que el cliente pueda registrar o consultar un siniestro.

El sistema debe contemplar un registro básico de siniestro utilizando datos ficticios.

### Información mínima considerada

- tipo de siniestro,
- fecha de ocurrencia,
- fecha de reporte,
- identificador ficticio del siniestro.

> El nivel definitivo de implementación de esta función deberá confirmarse con la rúbrica oficial.

---

## RF-03. Visualizar el detalle del siniestro

El usuario debe poder visualizar la información principal del siniestro consultado.

La información puede incluir:

- identificador,
- tipo de siniestro,
- fecha de ocurrencia,
- fecha de reporte,
- estado actual,
- equipo o colaborador asignado cuando corresponda,
- última actualización.

---

## RF-04. Visualizar el estado del siniestro

El sistema debe mostrar de manera comprensible la etapa actual del siniestro.

Los estados definidos para el proyecto son:

1. Recibido.
2. En evaluación.
3. En liquidación.
4. Cerrado.

---

## RF-05. Consultar el historial del siniestro

El usuario debe poder revisar las gestiones realizadas sobre su caso.

Cada registro del historial debe poder mostrar, como mínimo:

- fecha,
- descripción de la gestión,
- estado asociado.

El historial debe presentarse de manera ordenada.

---

## RF-06. Adjuntar evidencia

El sistema debe permitir asociar evidencia o documentación a un siniestro.

La aplicación debe contemplar:

- imágenes,
- captura mediante cámara cuando corresponda,
- documentos PDF.

Los archivos utilizados durante el desarrollo y demostración deben ser ficticios.

---

## RF-07. Consultar evidencias

El usuario debe poder visualizar las evidencias que se encuentren asociadas al siniestro.

---

## RF-08. Recibir notificaciones

El sistema debe informar al usuario cuando exista un cambio relevante en el siniestro.

Las notificaciones deben estar asociadas al caso correspondiente y permitir que el usuario conozca el cambio realizado.

Para el MVP se puede utilizar una representación interna o simulada de las notificaciones. El uso de push real dependerá de la rúbrica.

---

## RF-09. Actualizar la información del siniestro

Cuando cambie el estado de un siniestro, el sistema debe reflejar la nueva información en el seguimiento y en el historial correspondiente.

---

# 3. Requerimientos no funcionales

Los requerimientos no funcionales indican condiciones de calidad, restricciones técnicas y características que debe cumplir la solución.

## RNF-01. Plataforma

La aplicación móvil debe funcionar en dispositivos Android.

---

## RNF-02. Lenguaje de desarrollo

La aplicación Android debe desarrollarse utilizando Kotlin.

---

## RNF-03. Entorno de desarrollo

El proyecto móvil debe desarrollarse utilizando Android Studio.

---

## RNF-04. Interfaz de usuario

La interfaz debe implementarse utilizando Jetpack Compose.

---

## RNF-05. Diseño visual

La aplicación debe utilizar Material Design 3.

---

## RNF-06. Arquitectura móvil

La aplicación debe utilizar el patrón arquitectónico MVVM para separar la interfaz, el estado y la lógica de la aplicación.

---

## RNF-07. Persistencia local

La aplicación debe utilizar Room sobre SQLite para la persistencia local requerida por el MVP.

La interfaz de usuario no debe acceder directamente a la base de datos.

---

## RNF-08. Comunicación con servicios

La aplicación móvil debe utilizar Retrofit para consumir una API REST.

La comunicación con servicios remotos debe realizarse fuera de la capa de interfaz.

---

## RNF-09. Backend

El backend debe desarrollarse utilizando Spring Boot.

---

## RNF-10. API REST

El backend debe exponer servicios mediante una API REST que permita entregar la información necesaria para el funcionamiento del MVP.

---

## RNF-11. Arquitectura del backend

El caso solicita considerar una arquitectura basada en microservicios para las responsabilidades del backend.

La cantidad de servicios debe mantenerse acotada al alcance académico del proyecto.

---

## RNF-12. Pruebas

El backend debe incorporar pruebas unitarias para validar las funciones principales.

---

## RNF-13. Usabilidad

La aplicación debe ser fácil de utilizar para personas con diferentes edades y niveles de familiaridad tecnológica.

La interfaz debe ser:

- simple,
- clara,
- comprensible,
- de bajo esfuerzo cognitivo,
- consistente entre pantallas.

---

## RNF-14. Privacidad

El proyecto no debe utilizar información personal real de clientes o asegurados.

No se deben utilizar:

- pólizas reales,
- información médica real,
- información financiera real,
- credenciales reales,
- accesos a sistemas internos.

---

## RNF-15. Seguridad

La aplicación debe aplicar buenas prácticas básicas de seguridad y privacidad considerando que el contexto de los siniestros puede contener información sensible.

---

## RNF-16. Datos de prueba

Todos los datos utilizados en el desarrollo, pruebas y demostración deben ser ficticios, sintéticos o anonimizados.

---

## RNF-17. Integración externa

El MVP no debe conectarse a sistemas core reales de compañías de seguros.

La integración con una plataforma aseguradora debe ser simulada mediante la API académica desarrollada para el proyecto.

---

## RNF-18. Autenticación

El proyecto no requiere implementar un sistema de login real.

---

## RNF-19. Mantenibilidad

El código debe mantenerse organizado por responsabilidades para facilitar cambios posteriores.

En Android se utilizarán como referencia las capas:

- presentación,
- dominio,
- datos.

---

# 4. Resumen de requerimientos

| Código | Requerimiento | Tipo |
|---|---|---|
| RF-01 | Consultar siniestro | Funcional |
| RF-02 | Registrar siniestro | Funcional |
| RF-03 | Visualizar detalle | Funcional |
| RF-04 | Visualizar estado | Funcional |
| RF-05 | Consultar historial | Funcional |
| RF-06 | Adjuntar evidencia | Funcional |
| RF-07 | Consultar evidencias | Funcional |
| RF-08 | Recibir notificaciones | Funcional |
| RF-09 | Actualizar información ante cambios | Funcional |
| RNF-01 | Android | No funcional |
| RNF-02 | Kotlin | No funcional |
| RNF-03 | Android Studio | No funcional |
| RNF-04 | Jetpack Compose | No funcional |
| RNF-05 | Material Design 3 | No funcional |
| RNF-06 | MVVM | No funcional |
| RNF-07 | Room / SQLite | No funcional |
| RNF-08 | Retrofit | No funcional |
| RNF-09 | Spring Boot | No funcional |
| RNF-10 | API REST | No funcional |
| RNF-11 | Microservicios | No funcional |
| RNF-12 | Pruebas unitarias | No funcional |
| RNF-13 | Usabilidad | No funcional |
| RNF-14 | Privacidad | No funcional |
| RNF-15 | Seguridad | No funcional |
| RNF-16 | Datos ficticios | No funcional |
| RNF-17 | Sin integración core real | No funcional |
| RNF-18 | Sin login real | No funcional |
| RNF-19 | Mantenibilidad | No funcional |

---

# 5. Alcance actual del MVP

Actualmente se prioriza el siguiente recorrido:

```text
Inicio
  ↓
Consultar siniestro
  ↓
Detalle
  ↓
Seguimiento
  ↓
Historial
```

El resto de las capacidades se incorporará progresivamente manteniendo el alcance definido para el proyecto académico.

---

# 6. Regla de alcance

Antes de incorporar una nueva funcionalidad se debe comprobar que:

1. esté solicitada por el caso o la rúbrica,
2. aporte al flujo principal,
3. pueda ser demostrada,
4. pueda ser probada,
5. no agregue complejidad innecesaria.

La rúbrica oficial tendrá prioridad para definir el alcance final del proyecto.

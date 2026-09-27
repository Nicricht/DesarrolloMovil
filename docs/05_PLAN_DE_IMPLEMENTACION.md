# Plan de implementación

## 1. Estrategia

El objetivo es construir primero un flujo vertical completo y después agregar funciones.

No se debe intentar desarrollar todas las pantallas, todas las entidades y todos los microservicios al mismo tiempo.

## 2. Orden recomendado

### Fase 0 · Documentación y decisiones

Entregables:

- Visión y alcance.
- Arquitectura.
- Diseño funcional.
- Modelo de datos.
- Contrato REST.
- Revisión de rúbrica.

Criterio de salida:

Todo el equipo puede explicar qué problema resuelve la aplicación y cómo viajan los datos de Android al backend.

### Fase 1 · Esqueleto Android

Crear proyecto en Android Studio con:

- Kotlin.
- Jetpack Compose.
- Material 3.
- Navegación.
- Paquetes base para MVVM.

Pantallas inicialmente estáticas:

- Inicio.
- Mis siniestros.
- Detalle.
- Historial.

Criterio de salida:

La navegación funciona y la estructura del proyecto es comprensible.

### Fase 2 · Backend mínimo

Crear:

- siniestros-service.
- Modelo de siniestro.
- Datos ficticios.
- GET /siniestros/{id}.
- GET /siniestros/{id}/historial.
- Pruebas unitarias iniciales.

Criterio de salida:

Postman o equivalente obtiene un siniestro y su historial.

### Fase 3 · Integración Retrofit

Conectar Android al backend.

Criterio de salida:

El siniestro mostrado por la aplicación viene realmente de la API.

Este es el primer gran hito del proyecto.

### Fase 4 · Room

Agregar persistencia local.

Criterio de salida:

La aplicación conserva el último siniestro consultado y puede mostrar información cacheada básica.

### Fase 5 · Evidencias

Agregar:

- Selección de imagen.
- Cámara si corresponde.
- Selección de PDF.
- Envío mediante Retrofit.
- Registro de evidencia.

Criterio de salida:

Una evidencia ficticia queda asociada al siniestro.

### Fase 6 · Cambios de estado y notificaciones

Agregar:

- Cambio de estado académico/simulado.
- Evento en historial.
- Notificación asociada.
- Actualización de UI.

Criterio de salida:

Se puede demostrar:

```text
EN_EVALUACION
      ↓
EN_LIQUIDACION
      ↓
historial actualizado
      ↓
notificación visible
```

### Fase 7 · Calidad

Agregar:

- Validaciones.
- Manejo de loading/error/empty.
- Pruebas unitarias faltantes.
- Revisión Material 3.
- Accesibilidad básica.
- Limpieza de datos ficticios.
- README de ejecución.

### Fase 8 · Demostración

La demo final debe contar una historia, no solo mostrar pantallas.

Flujo sugerido:

1. Cliente abre la app.
2. Selecciona un siniestro.
3. Ve que está "En evaluación".
4. Revisa el historial.
5. Adjunta una fotografía.
6. Se simula un cambio del backend.
7. Aparece una notificación.
8. El cliente vuelve al detalle.
9. El estado ahora es "En liquidación".

## 3. Prioridades

### P0 · Imprescindible

- Proyecto Android funcional.
- Compose + Material 3.
- MVVM.
- Consulta de siniestro.
- Estado actual.
- Historial.
- Retrofit.
- API Spring Boot.
- Room/SQLite.
- Pruebas unitarias de backend.

### P1 · Necesario para completar el caso

- Adjuntar evidencia.
- Notificaciones.
- Cambio demostrable de estado.
- Datos ficticios consistentes.

### P2 · Mejoras

- Mejoras visuales.
- Animaciones.
- Offline más elaborado.
- Push real.
- Mayor cobertura de errores.

## 4. Definition of Done del MVP

El MVP puede considerarse completo académicamente cuando:

- Compila y ejecuta en Android.
- Usa las tecnologías obligatorias del caso.
- Consume una API REST con Retrofit.
- Persiste información con Room/SQLite.
- Permite consultar el estado de un siniestro.
- Muestra historial.
- Permite adjuntar evidencia.
- Representa notificaciones.
- Usa datos ficticios.
- El backend tiene pruebas unitarias.
- El flujo principal puede demostrarse de principio a fin.

## 5. Siguiente dependencia crítica

Antes de programar se debe revisar la **rúbrica oficial de evaluación**.

El caso define el problema y las restricciones técnicas, pero no especifica cuánto puntaje recibe cada criterio. Esa información debe condicionar el nivel de profundidad de cada módulo.

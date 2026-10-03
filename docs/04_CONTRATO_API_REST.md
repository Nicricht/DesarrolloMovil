# Contrato API REST propuesto

## 1. Objetivo

Definir un contrato inicial entre la aplicación Android y los microservicios Spring Boot.

Los endpoints de este documento son una **propuesta de implementación** basada en las funciones exigidas por el caso.

Base propuesta:

```text
/api/v1
```

## 2. Siniestros

### Registrar un siniestro

```http
POST /api/v1/siniestros
```

Request:

```json
{
  "tipo": "Accidente vehicular",
  "fechaOcurrencia": "2026-09-20",
  "fechaReporte": "2026-09-21"
}
```

Response:

```json
{
  "id": "SIN-2026-001",
  "tipo": "Accidente vehicular",
  "fechaOcurrencia": "2026-09-20",
  "fechaReporte": "2026-09-21",
  "estado": "RECIBIDO",
  "equipoAsignado": null
}
```

### Consultar siniestro

```http
GET /api/v1/siniestros/{id}
```

Response:

```json
{
  "id": "SIN-2026-001",
  "tipo": "Accidente vehicular",
  "fechaOcurrencia": "2026-09-20",
  "fechaReporte": "2026-09-21",
  "estado": "EN_EVALUACION",
  "equipoAsignado": "Equipo Norte",
  "ultimaActualizacion": "2026-09-24T15:30:00"
}
```

### Listar siniestros del entorno demo

```http
GET /api/v1/siniestros
```

Este endpoint es una conveniencia propuesta para el MVP sin login real.

## 3. Historial

### Consultar historial

```http
GET /api/v1/siniestros/{id}/historial
```

Response:

```json
[
  {
    "id": "H-003",
    "fechaHora": "2026-09-24T15:30:00",
    "descripcion": "Caso asignado a equipo liquidador",
    "estadoResultante": "EN_EVALUACION"
  },
  {
    "id": "H-001",
    "fechaHora": "2026-09-21T09:10:00",
    "descripcion": "Siniestro recibido",
    "estadoResultante": "RECIBIDO"
  }
]
```

## 4. Evidencias

### Adjuntar evidencia

```http
POST /api/v1/siniestros/{id}/evidencias
Content-Type: multipart/form-data
```

Campos propuestos:

- file
- descripcion opcional

Response:

```json
{
  "id": "E-001",
  "nombreArchivo": "foto_frontal.jpg",
  "tipoMime": "image/jpeg",
  "fechaCarga": "2026-09-24T16:00:00",
  "estadoCarga": "CARGADA"
}
```

### Listar evidencias

```http
GET /api/v1/siniestros/{id}/evidencias
```

## 5. Notificaciones

### Consultar notificaciones asociadas

```http
GET /api/v1/notificaciones?siniestroId={id}
```

Response:

```json
[
  {
    "id": "N-001",
    "siniestroId": "SIN-2026-001",
    "titulo": "Estado actualizado",
    "mensaje": "Tu siniestro cambió a En evaluación",
    "fechaHora": "2026-09-24T15:31:00",
    "leida": false
  }
]
```

### Marcar como leída

```http
PATCH /api/v1/notificaciones/{id}/leida
```

## 6. Endpoint académico para demostrar cambio de estado

Este endpoint no representa necesariamente una operación disponible para el cliente final. Se propone únicamente para facilitar la demostración del MVP.

```http
PATCH /api/v1/siniestros/{id}/estado
```

Request:

```json
{
  "estado": "EN_LIQUIDACION"
}
```

Efectos esperados:

1. Actualizar siniestro.
2. Agregar evento al historial.
3. Generar notificación.

## 7. Errores

Formato propuesto:

```json
{
  "timestamp": "2026-09-24T16:30:00",
  "status": 404,
  "code": "SINIESTRO_NO_ENCONTRADO",
  "message": "No existe un siniestro con el identificador indicado"
}
```

Estados HTTP mínimos:

- 200 OK.
- 201 Created.
- 400 Bad Request.
- 404 Not Found.
- 500 Internal Server Error.

## 8. Retrofit

**Estado actual:** base implementada para consulta de siniestro e historial.

Implementado en Android:

- Retrofit 2.11.0,
- converter Gson,
- `SiniestroDto`,
- `GestionHistorialDto`,
- `SiniestroApiService`,
- `RetrofitProvider`,
- permiso `INTERNET`,
- pruebas de contrato con MockWebServer.

La interfaz implementa actualmente:

```text
GET siniestros/{id}
GET siniestros/{id}/historial
```

URL base de desarrollo para el emulador Android:

```text
http://10.0.2.2:8080/api/v1/
```

Esta URL es una decisión técnica de desarrollo local. `10.0.2.2` permite que el emulador Android acceda al servidor que se ejecuta en el computador host.

La conexión de esta fuente remota con el Repository y el ViewModel corresponde al bloque A5. Los endpoints de evidencias y notificaciones se implementarán únicamente cuando su flujo sea desarrollado.

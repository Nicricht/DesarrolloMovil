# Microservicios Java de Seguros BPO

Dos aplicaciones independientes Spring Boot con Java 21 y Maven.

| Servicio | Puerto | Responsabilidad |
| --- | --- | --- |
| catalogos-service | 8081 | Compañías activas e inactivas, líneas de seguro, tipos de siniestro y documentos habituales |
| siniestros-service | 8080 | Denuncia, seguimiento, asignación, historial, cambios de etapa, documentos y avisos persistentes |

El catálogo contiene exclusivamente los datos ficticios de los anexos. Los siniestros se almacenan en H2 (archivo local `datos/siniestros.mv.db`), con JPA. No hay conexiones a aseguradoras reales.

## Ejecutar

Necesitas JDK 21 y Maven 3.6.3 o superior.

Desde `backend-java`:

```bash
mvn clean verify
mvn -pl catalogos-service spring-boot:run
```

En una segunda terminal, también dentro de `backend-java`:

```bash
mvn -pl siniestros-service spring-boot:run
```

Las URL base son `http://localhost:8081/api/v1/` y `http://localhost:8080/api/v1/`. En un emulador Android, el host local se alcanza mediante `http://10.0.2.2:8080/api/v1/`.

## Flujo de ejemplo

El encabezado `X-Role` puede ser `ASEGURADO`, `ANALISTA` o `LIQUIDADOR`. El encabezado `X-Actor-Id` identifica el RUT ficticio o el colaborador. Son identidades simuladas **solo para la demostración académica**, no autenticación de producción.

```bash
curl -X POST http://localhost:8080/api/v1/siniestros \
  -H 'Content-Type: application/json' \
  -H 'X-Role: ASEGURADO' -H 'X-Actor-Id: 15.842.371-5' \
  -d '{"compania":"ASG-01","tipo":"TS-01","fechaOcurrencia":"2026-09-02","comuna":"Maipú","descripcion":"Choque de prueba"}'
```

La respuesta devuelve un identificador `SIN-AA-NNNNNN`. Reemplaza `{numero}` por ese identificador en los siguientes endpoints:

| Método | Endpoint | Perfil |
| --- | --- | --- |
| POST | `/api/v1/siniestros` | Asegurado |
| GET | `/api/v1/siniestros` | Los tres perfiles, con filtros por propietario/asignación |
| GET | `/api/v1/siniestros/{numero}` | Titular, liquidador asignado o analista |
| GET | `/api/v1/siniestros/{numero}/historial` | Los tres perfiles; sin gestiones internas para el asegurado |
| POST | `/api/v1/siniestros/{numero}/asignacion` | Analista |
| POST | `/api/v1/siniestros/{numero}/gestiones` | Liquidador asignado |
| POST | `/api/v1/siniestros/{numero}/solicitudes` | Liquidador asignado |
| GET | `/api/v1/siniestros/{numero}/solicitudes` | Titular y colaboradores autorizados |
| POST | `/api/v1/siniestros/{numero}/documentos` | Titular o liquidador; multipart `archivo`, `tipo`, `solicitudId` opcional |
| GET | `/api/v1/siniestros/{numero}/documentos` | Titular y colaboradores autorizados |
| GET | `/api/v1/siniestros/{numero}/documentos/{documentoId}` | Titular y colaboradores autorizados |
| POST | `/api/v1/siniestros/{numero}/etapa` | Liquidador asignado |
| POST | `/api/v1/siniestros/{numero}/desistimiento` | Asegurado |
| GET | `/api/v1/avisos` | Asegurado |
| PATCH | `/api/v1/avisos/{avisoId}/leido` | Asegurado |

La respuesta de detalle conserva los campos ya utilizados por Retrofit: `id`, `tipo`, `fechaOcurrencia`, `fechaReporte`, `estado`, `equipoAsignado`, `ultimaActualizacion`. Para conectarlo al cliente Android, el cliente HTTP deberá incluir los dos encabezados de identidad simulada y disponer de las nuevas funciones REST.

## Reglas incluidas

- RUT válido; compañía activa y compatible con el siniestro; fecha de ocurrencia no futura; reportes de más de 30 días identificados.
- Numeración única; siniestros nuevos en `Recibido`; asignación compatible con Vehículos/Hogar.
- Avance ordenado: `Recibido` → `En evaluación` → `En liquidación` → `Cerrado`, con cierres anticipados permitidos por el caso.
- Bloqueo del paso a liquidación con solicitudes pendientes; cierre con resultado y mensaje.
- Documentos en PDF/PNG/JPEG, hasta 5 MiB y hasta 15 por siniestro; no admite adjuntos en casos cerrados.
- Gestiones internas ocultas; avisos persistidos ante asignación, cambios de etapa, solicitud y cierre.

## Alcance y límites

Es un backend académico con almacenamiento local H2. No incluye inicio de sesión real, control de permisos criptográficamente seguro, notificaciones push externas ni sincronización offline del móvil. Los encabezados de identidad pueden suplantarse, por lo que **no debe exponerse públicamente**. El frontend del ZIP se conserva intacto y su integración y pruebas instrumentadas deben verificarse por separado. Los datos de demostración deben ser exclusivamente ficticios. No se realizan pagos ni operaciones con aseguradoras.

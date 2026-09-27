# FORMATO DE CASO PARA DOCENTES Y ESTUDIANTES

## Desarrollo de Aplicaciones Móviles · DSY1105

## 1. Identificación del caso

| Antecedente | Información para el caso |
|---|---|
| Título breve del desafío | Seguimiento móvil del estado de siniestros para clientes de servicios BPO |
| Organización | Servicios Corporativos Andes SpA |
| Rubro o ámbito | Consultoría de gestión, externalización de procesos (BPO) y asesoría financiera |
| Sede / coordinador(a) CITT | Plaza Norte / Juan José Pierattini Vega |
| Asignatura | DSY1105 Desarrollo de Aplicaciones Móviles |
| Fecha de entrega al docente | 01-09-2026 |

## 2. Caso que se presentará a los equipos

### 2.1 Contexto de la organización

Servicios Corporativos Andes SpA es una consultora de Recursos Humanos, gestión estratégica y externalización de procesos (BPO) con más de 12 años de trayectoria y un equipo de entre 51 y 150 colaboradores. Ofrece reclutamiento y selección, outsourcing y servicios transitorios, y consultoría organizacional para medianas y grandes empresas de distintos sectores (retail, banca, minería). Dentro de sus servicios de BPO, apoya a empresas del rubro asegurador en la gestión operativa de la liquidación de siniestros.

### 2.2 Situación actual

Hoy la industria aseguradora, y por extensión los procesos que la organización gestiona como BPO para esos clientes, mantiene un alto nivel de procesos manuales en la gestión de siniestros, con mayores tiempos de gestión y trazabilidad limitada. El cliente asegurado que reporta un siniestro no cuenta con un canal propio para conocer en tiempo real el estado de su caso, por lo que debe recurrir a otros medios (teléfono, correo, oficina).

Los perfiles involucrados son:

- El cliente o asegurado que reporta y hace seguimiento de su siniestro.
- El colaborador o liquidador que recibe y evalúa los casos asignados.
- El equipo de administración de siniestros, encargado de normalizar y distribuir la carga de trabajo.

### 2.3 Necesidad o problema

El alto componente manual del proceso genera mayores tiempos de respuesta y dificulta la trazabilidad de cada caso, tanto para la organización que opera el proceso como para el cliente final. Este último no tiene visibilidad del estado de su siniestro mientras está en evaluación, lo que deteriora su experiencia de servicio y genera consultas adicionales por canales no digitales.

### 2.4 Mejora esperada

Se espera mejorar la eficiencia operativa, fortalecer la trazabilidad de los procesos y reducir los tiempos de respuesta percibidos por el cliente. En particular, se busca explorar una experiencia móvil que permita al cliente acceder en tiempo real al estado de su siniestro, mejorando la comunicación y su experiencia de servicio sin necesidad de contactar directamente a un colaborador.

## 3. Información necesaria para desarrollar la propuesta

### 3.1 Tareas o funciones de los perfiles usuarios

El cliente reporta un siniestro y hoy debe esperar contacto o consultar por canales tradicionales para conocer su estado.

Para el desafío académico, sus tareas serán:

- Registrar o consultar un siniestro.
- Adjuntar evidencia o documentación de respaldo.
- Revisar el estado y el historial de gestiones de su caso.
- Recibir notificaciones ante cambios relevantes.

Las dificultades a resolver son la falta de visibilidad en tiempo real, la dependencia de canales manuales de consulta y la baja trazabilidad percibida por el cliente.

### 3.2 Información necesaria para el proceso

- Identificador de siniestro ficticio.
- Tipo de siniestro.
- Fecha de ocurrencia y de reporte.
- Estado y etapa del caso: recibido, en evaluación, en liquidación, cerrado.
- Historial de gestiones.
- Documentación o evidencia adjunta (imágenes o PDF sintéticos).
- Colaborador o equipo asignado (referencial).
- Notificaciones.

No se utilizarán pólizas reales, datos personales reales de asegurados ni información médica o financiera real.

### 3.3 Condiciones de uso de la aplicación móvil

Uso principal en teléfonos Android, por clientes de distintas edades y niveles de familiaridad tecnológica, en cualquier momento tras reportar un siniestro. La cámara puede ser relevante para adjuntar evidencia.

Debe considerarse el envío de notificaciones push ante cambios de estado y una experiencia simple, clara y de bajo esfuerzo cognitivo, dado el contexto emocional que puede implicar un siniestro.

No se debe desarrollar el login real ni todas las vistas fuera del happy path, pero sí deben considerarse buenas prácticas de seguridad y protección de datos personales.

### 3.4 Conexión con otros sistemas o herramientas

El MVP móvil podría conectarse a una API REST (microservicios) que entregue el estado y el historial de un siniestro, simulando la información que en un escenario real provendría de la plataforma de liquidación de siniestros operada por la organización para sus clientes aseguradores, y de sus módulos de normalización y distribución automática de casos.

Quedan fuera del alcance académico la implementación productiva de dichos módulos y la integración con sistemas core de pólizas u otros sistemas internos de la aseguradora.

## 4. Criterios para considerar útil la propuesta

### 4.1 Resultados o señales de éxito

- Tiempo que le toma al cliente conocer el estado de su siniestro.
- Reducción de consultas por canales tradicionales (teléfono, correo, oficina).
- Mayor trazabilidad visible del caso para el cliente.
- Disponibilidad de la información en tiempo real.
- Disminución de errores en la gestión manual.
- Mejor experiencia de servicio durante un proceso habitualmente estresante para el cliente.

## 5. Restricciones que deben considerar los equipos

### 5.1 Condiciones o límites del caso

El entregable es una propuesta de solución tecnológica materializada en un MVP; no corresponde al desarrollo definitivo ni a la publicación productiva de una aplicación.

Debe desarrollarse con:

### Frontend
- Kotlin.
- Android Studio.
- Jetpack Compose.
- Material Design 3.
- Arquitectura MVVM.
- Persistencia local en Room/SQLite.

### Backend
- Microservicios Spring Boot.
- API REST.
- Pruebas unitarias.

### Integración
- Retrofit.

Solo se utilizarán datos ficticios, sintéticos o anonimizados: no se compartirán pólizas reales, datos personales de asegurados, credenciales ni accesos a sistemas internos.

## 6. Material de apoyo que se entregará

| Material | Para qué se utilizará | Revisión |
|---|---|---|
| Estados y API mock del proceso de liquidación de siniestros | Probar la consulta del estado del siniestro en tiempo real | Depurado |

---

Fuente académica: caso DSY1105 entregado para el desafío de Desarrollo de Aplicaciones Móviles.

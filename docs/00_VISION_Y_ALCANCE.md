# Visión y alcance del MVP

## 1. Propósito

El proyecto DSY1105 propone un MVP móvil para **seguimiento del estado de siniestros** de clientes atendidos en procesos BPO del rubro asegurador.

El problema central del caso es la falta de visibilidad del cliente sobre el estado de su siniestro y la dependencia de canales manuales como teléfono, correo u oficina. El MVP debe reducir esa fricción dando acceso móvil al estado, historial y documentación del caso.

## 2. Usuario principal

### Cliente o asegurado

Es quien reporta o consulta un siniestro y necesita saber qué está ocurriendo con su caso sin depender de atención manual.

### Otros perfiles del contexto

El caso también menciona:

- Colaborador o liquidador.
- Equipo de administración de siniestros.

Para el MVP móvil, el foco principal será el **cliente**. Los demás perfiles se consideran actores del proceso, pero no requieren una aplicación administrativa completa dentro del alcance académico.

## 3. Capacidades obligatorias del MVP

El MVP debe permitir:

1. Registrar o consultar un siniestro.
2. Consultar el estado actual del caso.
3. Revisar el historial de gestiones.
4. Adjuntar evidencia o documentación de respaldo.
5. Recibir notificaciones ante cambios relevantes.
6. Trabajar con información ficticia, sintética o anonimizada.

Estados mínimos descritos en el caso:

- Recibido.
- En evaluación.
- En liquidación.
- Cerrado.

## 4. Restricciones del caso

### Frontend móvil

- Android.
- Kotlin.
- Android Studio.
- Jetpack Compose.
- Material Design 3.
- Arquitectura MVVM.
- Persistencia local con Room/SQLite.
- Integración remota vía Retrofit.

### Backend

- Spring Boot.
- API REST.
- Microservicios.
- Pruebas unitarias.

### Datos

No se usarán:

- Pólizas reales.
- Datos personales reales.
- Información médica real.
- Información financiera real.
- Credenciales o accesos a sistemas internos.

## 5. Fuera de alcance

El caso deja fuera del alcance académico:

- Integración real con sistemas core de aseguradoras.
- Implementación productiva de módulos de normalización y distribución de casos.
- Login real.
- Cobertura completa de todos los flujos excepcionales.
- Publicación productiva de la aplicación.

## 6. Criterios de éxito

La propuesta debe apuntar a:

- Disminuir el tiempo que tarda el cliente en conocer el estado de su caso.
- Reducir consultas por teléfono, correo u oficina.
- Mejorar la trazabilidad visible del siniestro.
- Dar acceso oportuno a la información.
- Reducir errores derivados de procesos manuales.
- Mejorar la experiencia durante un proceso potencialmente estresante.

## 7. Principio rector

> El MVP debe demostrar de punta a punta que un cliente puede consultar y comprender el estado de su siniestro desde Android, revisar su historial, adjuntar evidencia y enterarse de cambios relevantes sin depender de atención manual.

## 8. Supuestos de diseño propuestos

Los siguientes puntos son decisiones propuestas para concretar el caso y no requisitos textuales del documento original:

- Se trabajará con un conjunto pequeño de siniestros ficticios.
- El flujo principal será el happy path.
- La aplicación podrá iniciar directamente en una pantalla de consulta o listado, sin autenticación real.
- El backend se dividirá inicialmente en pocos microservicios para evitar complejidad innecesaria.
- Las funciones no críticas podrán simularse cuando el caso no exija una integración productiva.

# Casos de uso del MVP

Este documento resume los casos de uso principales del proyecto. Se dejaron solamente los necesarios para el flujo principal del caso.

---

## CU-01 · Consultar siniestro

**Actor principal:** Cliente

**Objetivo:** Consultar un siniestro usando su identificador.

**Precondición:** Debe existir un siniestro ficticio registrado.

### Flujo principal

1. El cliente entra a la opción de consultar siniestro.
2. Ingresa el identificador.
3. La aplicación envía la consulta al backend.
4. El backend busca el siniestro.
5. La aplicación recibe los datos.
6. Se muestra el detalle del siniestro.

### Resultado esperado

El cliente puede ver:

- identificador,
- tipo,
- fecha de ocurrencia,
- fecha de reporte,
- estado,
- equipo asignado,
- última actualización.

### Flujo alternativo

Si el siniestro no existe, la aplicación muestra un mensaje indicando que no fue encontrado.

---

## CU-02 · Ver estado del siniestro

**Actor principal:** Cliente

**Objetivo:** Entender rápidamente en qué etapa se encuentra el caso.

### Flujo principal

1. El cliente abre el detalle del siniestro.
2. La aplicación obtiene el estado actual.
3. Se muestran las etapas del proceso.
4. Se destaca la etapa actual.

### Estados considerados

- Recibido.
- En evaluación.
- En liquidación.
- Cerrado.

### Resultado esperado

El cliente puede identificar sin dificultad el estado actual.

---

## CU-03 · Ver historial

**Actor principal:** Cliente

**Objetivo:** Revisar las gestiones realizadas sobre el siniestro.

### Flujo principal

1. El cliente abre el detalle del siniestro.
2. Selecciona "Historial".
3. La aplicación consulta el historial asociado.
4. Se muestran las gestiones en orden cronológico.

### Información mostrada

- fecha,
- hora,
- descripción,
- estado resultante cuando corresponda.

### Resultado esperado

El cliente puede revisar qué ha pasado con su caso.

---

## CU-04 · Adjuntar evidencia

**Actor principal:** Cliente

**Objetivo:** Adjuntar documentación relacionada con el siniestro.

### Flujo principal

1. El cliente entra a "Evidencias".
2. Selecciona "Adjuntar evidencia".
3. Elige una opción:
   - tomar foto,
   - seleccionar imagen,
   - seleccionar PDF.
4. La aplicación valida el archivo.
5. Se envía al backend.
6. El backend registra la evidencia.
7. La aplicación informa que la carga fue realizada.

### Flujo alternativo

Si ocurre un error, se muestra un mensaje y se permite intentar nuevamente.

### Resultado esperado

La evidencia queda asociada al siniestro.

---

## CU-05 · Ver notificaciones

**Actor principal:** Cliente

**Objetivo:** Conocer cambios importantes del siniestro.

### Flujo principal

1. Se produce un cambio relevante en el caso.
2. El backend registra una notificación.
3. La aplicación consulta las notificaciones.
4. El cliente abre la sección.
5. Se muestran los mensajes asociados.

### Resultado esperado

El cliente puede enterarse de cambios sin tener que consultar por otros canales.

---

## CU-06 · Cambio de estado para demostración

**Actor principal:** Sistema / entorno de demostración

**Objetivo:** Poder mostrar durante la demo cómo cambia un siniestro.

### Flujo principal

1. Se cambia el estado desde el backend o endpoint de demostración.
2. El backend actualiza el siniestro.
3. Se agrega una entrada al historial.
4. Se crea una notificación.
5. Android vuelve a consultar los datos.
6. La interfaz muestra el nuevo estado.

### Resultado esperado

Se puede demostrar el flujo completo del MVP.

---

# Resumen

Los casos de uso mínimos del proyecto son:

1. Consultar siniestro.
2. Ver estado.
3. Ver historial.
4. Adjuntar evidencia.
5. Ver notificaciones.
6. Cambiar estado para demostración.

No se agregan más casos de uso por ahora para mantener el proyecto acotado.

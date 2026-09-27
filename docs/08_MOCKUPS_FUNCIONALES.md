# Mockups funcionales

Los siguientes mockups son simples y sirven para definir la estructura de las pantallas antes de comenzar a programar.

---

# 1. Inicio

```text
┌──────────────────────────────┐
│ Seguimiento de Siniestros    │
├──────────────────────────────┤
│                              │
│ Bienvenido                   │
│                              │
│ Consulta el estado de tus    │
│ siniestros de forma simple.  │
│                              │
│ [ Ver mis siniestros ]       │
│                              │
│ [ Consultar siniestro ]      │
│                              │
│ Notificaciones          🔔    │
│                              │
└──────────────────────────────┘
```

---

# 2. Consultar siniestro

```text
┌──────────────────────────────┐
│ ← Consultar siniestro        │
├──────────────────────────────┤
│                              │
│ Identificador del siniestro  │
│                              │
│ [ SIN-2026-001___________ ]  │
│                              │
│ [        Buscar          ]   │
│                              │
│ Ejemplo: SIN-2026-001        │
│                              │
└──────────────────────────────┘
```

---

# 3. Mis siniestros

```text
┌──────────────────────────────┐
│ ← Mis siniestros             │
├──────────────────────────────┤
│                              │
│ ┌──────────────────────────┐ │
│ │ SIN-2026-001             │ │
│ │ Accidente vehicular      │ │
│ │ En evaluación            │ │
│ │ Actualizado 24/09/2026   │ │
│ └──────────────────────────┘ │
│                              │
│ ┌──────────────────────────┐ │
│ │ SIN-2026-002             │ │
│ │ Robo domiciliario        │ │
│ │ Recibido                 │ │
│ │ Actualizado 23/09/2026   │ │
│ └──────────────────────────┘ │
│                              │
└──────────────────────────────┘
```

---

# 4. Detalle del siniestro

```text
┌──────────────────────────────┐
│ ← Detalle                    │
├──────────────────────────────┤
│                              │
│ SIN-2026-001                 │
│ Accidente vehicular          │
│                              │
│ Estado actual                │
│ [ EN EVALUACIÓN ]            │
│                              │
│ Fecha ocurrencia 20/09/2026  │
│ Fecha reporte    21/09/2026  │
│ Equipo           Equipo Norte│
│                              │
│ [ Ver seguimiento ]          │
│ [ Ver historial ]            │
│ [ Ver evidencias ]           │
│                              │
└──────────────────────────────┘
```

---

# 5. Seguimiento

```text
┌──────────────────────────────┐
│ ← Seguimiento                │
├──────────────────────────────┤
│                              │
│  ✓  Recibido                 │
│  │                           │
│  ●  En evaluación            │
│  │                           │
│  ○  En liquidación           │
│  │                           │
│  ○  Cerrado                  │
│                              │
│ Estado actual:               │
│ En evaluación                │
│                              │
└──────────────────────────────┘
```

---

# 6. Historial

```text
┌──────────────────────────────┐
│ ← Historial                  │
├──────────────────────────────┤
│                              │
│ 24/09/2026 · 15:30           │
│ Caso asignado a liquidador   │
│ Estado: En evaluación        │
│                              │
│ --------------------------   │
│                              │
│ 22/09/2026 · 10:00           │
│ Documentación recibida       │
│                              │
│ --------------------------   │
│                              │
│ 21/09/2026 · 09:10           │
│ Siniestro registrado         │
│                              │
└──────────────────────────────┘
```

---

# 7. Evidencias

```text
┌──────────────────────────────┐
│ ← Evidencias                 │
├──────────────────────────────┤
│                              │
│ foto_frontal.jpg             │
│ Imagen · Cargada             │
│                              │
│ denuncia.pdf                 │
│ PDF · Cargada                │
│                              │
│                              │
│                       [ + ]  │
│                              │
└──────────────────────────────┘
```

Al presionar "+" se muestran:

```text
Adjuntar evidencia

[ Tomar foto ]
[ Seleccionar imagen ]
[ Seleccionar PDF ]
[ Cancelar ]
```

---

# 8. Notificaciones

```text
┌──────────────────────────────┐
│ ← Notificaciones             │
├──────────────────────────────┤
│                              │
│ Estado actualizado           │
│ Tu siniestro cambió a        │
│ En liquidación               │
│ 25/09/2026 · 09:15           │
│                              │
│ --------------------------   │
│                              │
│ Documento recibido           │
│ Se agregó una evidencia      │
│ 24/09/2026 · 16:20           │
│                              │
└──────────────────────────────┘
```

---

# Flujo visual principal

```text
Inicio
 ↓
Mis siniestros
 ↓
Detalle
 ├── Seguimiento
 ├── Historial
 └── Evidencias

Inicio
 ↓
Notificaciones
```

Estos mockups son una referencia inicial. El diseño final se implementará con Material Design 3.

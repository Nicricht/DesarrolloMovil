# Decisiones técnicas iniciales

Estas decisiones son provisionales y pueden cambiar cuando tengamos la pauta. Por ahora se eligieron opciones simples para no complicar el MVP.

---

## 1. Base de datos del backend

**Decisión inicial:** H2.

### Motivo

- Es fácil de configurar con Spring Boot.
- Sirve para trabajar con datos ficticios.
- Evita instalar una base de datos externa en la primera etapa.
- Es suficiente para un MVP académico.

Si más adelante la pauta exige una base de datos más completa, se puede cambiar a PostgreSQL.

---

## 2. Persistencia en Android

**Decisión:** Room sobre SQLite.

### Motivo

Es una tecnología exigida por el caso y permite guardar información localmente.

Se usará principalmente para:

- siniestros consultados,
- historial,
- notificaciones,
- información necesaria para cache.

---

## 3. Comunicación Android - backend

**Decisión:** Retrofit.

### Motivo

Es una tecnología indicada directamente en el caso.

La comunicación será mediante JSON y API REST.

---

## 4. Arquitectura Android

**Decisión:** MVVM.

### Capas principales

- UI.
- ViewModel.
- Repository.
- fuentes de datos local y remota.

No se agregará más complejidad arquitectónica mientras no sea necesaria.

---

## 5. Backend

**Decisión actual:** Kotlin + Spring Boot.

Se mantendrán responsabilidades separadas para:

- siniestros,
- notificaciones.

La división final en microservicios se mantendrá simple.

---

## 6. Notificaciones

**Decisión inicial:** Notificaciones internas simuladas.

### Motivo

El caso pide considerar notificaciones push, pero no exige explícitamente una integración productiva.

Primero se implementará:

- registro de notificación,
- consulta desde Android,
- visualización en pantalla.

Firebase Cloud Messaging quedará como mejora opcional si la pauta lo exige.

---

## 7. Evidencias

**Decisión inicial:** Guardar metadatos y una referencia simple al archivo.

No se implementará almacenamiento en nube durante la primera versión.

La evidencia podrá ser:

- imagen,
- fotografía,
- PDF.

---

## 8. Login

**Decisión:** No implementar login real.

El caso indica que no es necesario desarrollar un login productivo.

Para la demostración se trabajará con datos ficticios precargados.

---

## 9. Estrategia de sincronización

**Decisión inicial:** La API será la fuente principal y Room funcionará como cache local.

Flujo:

```text
API
 ↓
Repository
 ↓
Room
 ↓
ViewModel
 ↓
UI
```

Cuando la API entregue datos nuevos, Room se actualiza.

Si hay un fallo de red, se podrá mostrar la información local disponible.

---

## 10. Git

**Decisión:** GitFlow simplificado.

Ramas:

- main
- develop
- feature/*
- docs/*
- release/* cuando corresponda
- hotfix/* cuando corresponda

No se trabajará directamente sobre main.

---

# Resumen de decisiones actuales

| Tema | Decisión |
|---|---|
| Backend | Kotlin + Spring Boot |
| Base de datos backend | H2 |
| Android | Kotlin + Compose |
| Arquitectura | MVVM |
| Persistencia local | Room / SQLite |
| API | REST |
| Cliente HTTP | Retrofit |
| Notificaciones | Simuladas inicialmente |
| Evidencias | Metadata + referencia |
| Login real | No |
| Git | GitFlow simplificado |

Estas decisiones se pueden ajustar cuando tengamos la pauta.

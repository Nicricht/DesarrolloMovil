package cl.duoc.siniestrosbpo.domain.model

enum class EstadoSiniestro {
    RECIBIDO,
    EN_EVALUACION,
    EN_LIQUIDACION,
    CERRADO
}

data class Siniestro(
    val id: String,
    val tipo: String,
    val fechaOcurrencia: String,
    val fechaReporte: String,
    val estado: EstadoSiniestro,
    val equipoAsignado: String? = null,
    val ultimaActualizacion: String? = null
)

data class GestionHistorial(
    val id: String,
    val siniestroId: String,
    val fechaHora: String,
    val descripcion: String,
    val estadoResultante: EstadoSiniestro
)

enum class EstadoCargaEvidencia {
    PENDIENTE,
    CARGADA,
    ERROR
}

data class Evidencia(
    val id: String,
    val siniestroId: String,
    val nombreArchivo: String,
    val tipoMime: String,
    val uriLocal: String? = null,
    val urlRemota: String? = null,
    val fechaCarga: String,
    val estadoCarga: EstadoCargaEvidencia = EstadoCargaEvidencia.PENDIENTE
)

data class Notificacion(
    val id: String,
    val siniestroId: String,
    val titulo: String,
    val mensaje: String,
    val fechaHora: String,
    val leida: Boolean = false
)

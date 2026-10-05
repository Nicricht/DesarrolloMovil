package com.example.seguimientosiniestros.domain.validation

object ConsultaSiniestroValidator {

    private val formato = Regex("^SIN-\\d{4}-\\d{3}$")

    fun validar(identificador: String): String? {
        val valor = normalizar(identificador)

        return when {
            valor.isBlank() -> "El identificador es obligatorio."
            !formato.matches(valor) -> "Usa el formato SIN-AAAA-000."
            else -> null
        }
    }

    fun normalizar(identificador: String): String {
        return identificador.trim().uppercase()
    }
}

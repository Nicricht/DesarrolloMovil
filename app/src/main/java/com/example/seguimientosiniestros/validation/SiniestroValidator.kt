package com.example.seguimientosiniestros.validation

object SiniestroValidator {

    private val patronIdentificador = Regex("^SIN-\\d{4}-\\d{3}$")

    fun validarIdentificador(valor: String): String? {
        val identificador = valor.trim().uppercase()

        return when {
            identificador.isEmpty() -> "El identificador es obligatorio."
            !patronIdentificador.matches(identificador) -> "Usa el formato SIN-2026-001."
            else -> null
        }
    }
}

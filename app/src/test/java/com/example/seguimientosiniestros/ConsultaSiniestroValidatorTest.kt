package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.domain.validation.ConsultaSiniestroValidator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ConsultaSiniestroValidatorTest {

    @Test
    fun identificadorVacioMuestraErrorObligatorio() {
        val resultado = ConsultaSiniestroValidator.validar("   ")

        assertEquals("El identificador es obligatorio.", resultado)
    }

    @Test
    fun identificadorConFormatoIncorrectoMuestraError() {
        val resultado = ConsultaSiniestroValidator.validar("123")

        assertEquals("Usa el formato SIN-AAAA-000.", resultado)
    }

    @Test
    fun identificadorValidoNoTieneError() {
        val resultado = ConsultaSiniestroValidator.validar("sin-2026-001")

        assertNull(resultado)
    }

    @Test
    fun normalizarLimpiaEspaciosYConvierteAMayusculas() {
        val resultado = ConsultaSiniestroValidator.normalizar("  sin-2026-001  ")

        assertEquals("SIN-2026-001", resultado)
    }
}

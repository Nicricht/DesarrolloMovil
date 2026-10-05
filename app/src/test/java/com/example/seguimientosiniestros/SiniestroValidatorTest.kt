package com.example.seguimientosiniestros

import com.example.seguimientosiniestros.validation.SiniestroValidator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SiniestroValidatorTest {

    @Test
    fun identificadorVacioMuestraErrorObligatorio() {
        assertEquals(
            "El identificador es obligatorio.",
            SiniestroValidator.validarIdentificador("   ")
        )
    }

    @Test
    fun identificadorConFormatoIncorrectoMuestraError() {
        assertEquals(
            "Usa el formato SIN-2026-001.",
            SiniestroValidator.validarIdentificador("SIN-26-1")
        )
    }

    @Test
    fun identificadorValidoAceptaMinusculasYEspacios() {
        assertNull(
            SiniestroValidator.validarIdentificador("  sin-2026-001  ")
        )
    }
}

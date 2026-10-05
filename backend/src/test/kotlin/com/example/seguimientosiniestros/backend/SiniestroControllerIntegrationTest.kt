package com.example.seguimientosiniestros.backend

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class SiniestroControllerIntegrationTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun healthResponde200() {
        mockMvc.perform(get("/api/v1/health"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.status").value("UP"))
    }

    @Test
    fun consultaValidaResponde200() {
        mockMvc.perform(get("/api/v1/siniestros/SIN-2026-001"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value("SIN-2026-001"))
            .andExpect(jsonPath("$.estado").value("EN_EVALUACION"))
            .andExpect(jsonPath("$.equipoAsignado").value("Equipo Norte"))
    }

    @Test
    fun consultaInexistenteResponde404() {
        mockMvc.perform(get("/api/v1/siniestros/SIN-INEXISTENTE"))
            .andExpect(status().isNotFound)
    }

    @Test
    fun historialValidoRespondeOrdenDescendente() {
        mockMvc.perform(get("/api/v1/siniestros/SIN-2026-001/historial"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$[0].id").value("H-003"))
            .andExpect(jsonPath("$[1].id").value("H-002"))
            .andExpect(jsonPath("$[2].id").value("H-001"))
    }

    @Test
    fun historialInexistenteResponde404() {
        mockMvc.perform(get("/api/v1/siniestros/SIN-INEXISTENTE/historial"))
            .andExpect(status().isNotFound)
    }
}

package com.example.seguimientosiniestros.backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class SiniestroControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void healthResponde200() throws Exception {
        mockMvc.perform(get("/api/v1/health"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("UP"));
    }

    @Test
    void consultaValidaResponde200() throws Exception {
        mockMvc.perform(get("/api/v1/siniestros/SIN-2026-001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("SIN-2026-001"))
                .andExpect(jsonPath("$.estado").value("EN_EVALUACION"))
                .andExpect(jsonPath("$.equipoAsignado").value("Equipo Norte"));
    }

    @Test
    void consultaInexistenteResponde404() throws Exception {
        mockMvc.perform(get("/api/v1/siniestros/SIN-INEXISTENTE"))
                .andExpect(status().isNotFound());
    }

    @Test
    void historialValidoRespondeOrdenDescendente() throws Exception {
        mockMvc.perform(get("/api/v1/siniestros/SIN-2026-001/historial"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("H-003"))
                .andExpect(jsonPath("$[1].id").value("H-002"))
                .andExpect(jsonPath("$[2].id").value("H-001"));
    }

    @Test
    void historialInexistenteResponde404() throws Exception {
        mockMvc.perform(get("/api/v1/siniestros/SIN-INEXISTENTE/historial"))
                .andExpect(status().isNotFound());
    }
}

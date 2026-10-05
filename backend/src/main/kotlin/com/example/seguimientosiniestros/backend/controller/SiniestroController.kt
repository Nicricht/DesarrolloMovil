package com.example.seguimientosiniestros.backend.controller

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse
import com.example.seguimientosiniestros.backend.service.SiniestroService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class SiniestroController(
    private val service: SiniestroService
) {
    @GetMapping("/health")
    fun health(): Map<String, String> = mapOf("status" to "UP")

    @GetMapping("/siniestros/{id}")
    fun obtenerSiniestro(@PathVariable id: String): SiniestroResponse =
        service.obtenerSiniestro(id)

    @GetMapping("/siniestros/{id}/historial")
    fun obtenerHistorial(@PathVariable id: String): List<GestionHistorialResponse> =
        service.obtenerHistorial(id)
}

package com.example.seguimientosiniestros.backend.controller;

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse;
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse;
import com.example.seguimientosiniestros.backend.service.SiniestroService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SiniestroController {

    private final SiniestroService service;

    public SiniestroController(SiniestroService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP");
    }

    @GetMapping("/siniestros/{id}")
    public SiniestroResponse obtenerSiniestro(@PathVariable String id) {
        return service.obtenerSiniestro(id);
    }

    @GetMapping("/siniestros/{id}/historial")
    public List<GestionHistorialResponse> obtenerHistorial(@PathVariable String id) {
        return service.obtenerHistorial(id);
    }
}

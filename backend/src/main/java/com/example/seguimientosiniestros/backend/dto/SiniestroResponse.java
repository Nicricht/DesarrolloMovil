package com.example.seguimientosiniestros.backend.dto;

public record SiniestroResponse(
        String id,
        String tipo,
        String fechaOcurrencia,
        String fechaReporte,
        String estado,
        String equipoAsignado,
        String ultimaActualizacion
) {
}

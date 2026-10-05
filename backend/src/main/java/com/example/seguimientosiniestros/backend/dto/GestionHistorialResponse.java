package com.example.seguimientosiniestros.backend.dto;

public record GestionHistorialResponse(
        String id,
        String fechaHora,
        String descripcion,
        String estadoResultante
) {
}

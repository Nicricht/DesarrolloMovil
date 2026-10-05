package com.example.seguimientosiniestros.backend.repository;

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse;
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse;
import java.util.List;
import java.util.Optional;

public interface SiniestroRepository {

    Optional<SiniestroResponse> findById(String id);

    List<GestionHistorialResponse> findHistorialBySiniestroId(String siniestroId);
}

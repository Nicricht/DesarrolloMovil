package com.example.seguimientosiniestros.backend.repository;

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse;
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class InMemorySiniestroRepository implements SiniestroRepository {

    private static final String DEMO_ID = "SIN-2026-001";

    private final Map<String, SiniestroResponse> siniestros = Map.of(
            DEMO_ID,
            new SiniestroResponse(
                    DEMO_ID,
                    "Accidente vehicular",
                    "2026-09-20",
                    "2026-09-21",
                    "EN_EVALUACION",
                    "Equipo Norte",
                    "2026-09-24T15:30:00"
            )
    );

    private final Map<String, List<GestionHistorialResponse>> historial = Map.of(
            DEMO_ID,
            List.of(
                    new GestionHistorialResponse(
                            "H-001",
                            "2026-09-21T09:10:00",
                            "Siniestro recibido",
                            "RECIBIDO"
                    ),
                    new GestionHistorialResponse(
                            "H-002",
                            "2026-09-22T10:00:00",
                            "Documentación recibida",
                            null
                    ),
                    new GestionHistorialResponse(
                            "H-003",
                            "2026-09-24T15:30:00",
                            "Caso asignado a equipo liquidador",
                            "EN_EVALUACION"
                    )
            )
    );

    @Override
    public Optional<SiniestroResponse> findById(String id) {
        return Optional.ofNullable(siniestros.get(id));
    }

    @Override
    public List<GestionHistorialResponse> findHistorialBySiniestroId(String siniestroId) {
        return historial.getOrDefault(siniestroId, List.of()).stream()
                .sorted(Comparator.comparing(GestionHistorialResponse::fechaHora).reversed())
                .toList();
    }
}

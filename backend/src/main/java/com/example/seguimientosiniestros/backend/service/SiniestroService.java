package com.example.seguimientosiniestros.backend.service;

import com.example.seguimientosiniestros.backend.dto.GestionHistorialResponse;
import com.example.seguimientosiniestros.backend.dto.SiniestroResponse;
import com.example.seguimientosiniestros.backend.repository.SiniestroRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SiniestroService {

    private final SiniestroRepository repository;

    public SiniestroService(SiniestroRepository repository) {
        this.repository = repository;
    }

    public SiniestroResponse obtenerSiniestro(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No existe un siniestro con el identificador indicado"
                ));
    }

    public List<GestionHistorialResponse> obtenerHistorial(String id) {
        obtenerSiniestro(id);
        return repository.findHistorialBySiniestroId(id);
    }
}

package com.generation.miniforo.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PublicacionResponseDTO(
        String id,
        String autorId,
        String titulo,
        String contenido,
        LocalDateTime fecha,
        List<ComentarioResponseDTO> comentarios
) {
}
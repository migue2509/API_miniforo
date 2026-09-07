package com.generation.miniforo.dto;

import java.time.LocalDateTime;

public record ComentarioResponseDTO(
        String autorNombre,
        String texto,
        LocalDateTime fecha
) {
}
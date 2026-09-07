package com.generation.miniforo.dto;

import jakarta.validation.constraints.NotBlank;

public record PublicacionRequestDTO(
        @NotBlank(message = "El autorId es obligatorio")
        String autorId,

        @NotBlank(message = "El título es obligatorio")
        String titulo,

        @NotBlank(message = "El contenido es obligatorio")
        String contenido
) {
}
package com.generation.miniforo.dto;

import jakarta.validation.constraints.NotBlank;

public record ComentarioRequestDTO(
        @NotBlank(message = "El nombre del autor del comentario es obligatorio")
        String autorNombre,

        @NotBlank(message = "El texto del comentario es obligatorio")
        String texto
) {
}
package com.generation.miniforo.dto;

import java.util.Map;

public record UsuarioResponseDTO(
        String id,
        String nombre,
        String email,
        Map<String, Object> datosPerfil
) {
}
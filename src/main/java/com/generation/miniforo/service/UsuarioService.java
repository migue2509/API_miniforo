package com.generation.miniforo.service;

import com.generation.miniforo.dto.UsuarioRequestDTO;
import com.generation.miniforo.dto.UsuarioResponseDTO;
import com.generation.miniforo.model.Usuario;
import com.generation.miniforo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO crearUsuario(UsuarioRequestDTO datos) {
        Usuario usuario = new Usuario(datos.nombre(), datos.email(), datos.datosPerfil());
        Usuario creado = usuarioRepository.save(usuario);
        return mapearAResponseDTO(creado);
    }

    public List<UsuarioResponseDTO> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::mapearAResponseDTO)
                .toList();
    }

    private UsuarioResponseDTO mapearAResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getDatosPerfil()
        );
    }
}
package com.generation.miniforo.controller;

import com.generation.miniforo.dto.ComentarioRequestDTO;
import com.generation.miniforo.dto.PublicacionRequestDTO;
import com.generation.miniforo.dto.PublicacionResponseDTO;
import com.generation.miniforo.service.PublicacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionController {

    private final PublicacionService publicacionService;

    public PublicacionController(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @PostMapping
    public ResponseEntity<PublicacionResponseDTO> crear(@Valid @RequestBody PublicacionRequestDTO dto) {
        PublicacionResponseDTO creada = publicacionService.crearPublicacion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    @GetMapping
    public List<PublicacionResponseDTO> listar() {
        return publicacionService.listarPublicaciones();
    }

    @GetMapping("/autor/{autorId}")
    public List<PublicacionResponseDTO> listarPorAutor(@PathVariable String autorId) {
        return publicacionService.listarPorAutor(autorId);
    }

    @PostMapping("/{id}/comentarios")
    public PublicacionResponseDTO agregarComentario(@PathVariable String id, @Valid @RequestBody ComentarioRequestDTO dto) {
        return publicacionService.agregarComentario(id, dto);
    }
}
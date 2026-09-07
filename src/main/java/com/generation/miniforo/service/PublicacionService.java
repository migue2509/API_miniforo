package com.generation.miniforo.service;

import com.generation.miniforo.dto.ComentarioRequestDTO;
import com.generation.miniforo.dto.ComentarioResponseDTO;
import com.generation.miniforo.dto.PublicacionRequestDTO;
import com.generation.miniforo.dto.PublicacionResponseDTO;
import com.generation.miniforo.model.Comentario;
import com.generation.miniforo.model.Publicacion;
import com.generation.miniforo.repository.PublicacionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;

    public PublicacionService(PublicacionRepository publicacionRepository) {
        this.publicacionRepository = publicacionRepository;
    }

    public PublicacionResponseDTO crearPublicacion(PublicacionRequestDTO datos) {
        Publicacion publicacion = new Publicacion(
                datos.autorId(),
                datos.titulo(),
                datos.contenido(),
                LocalDateTime.now()
        );

        Publicacion creada = publicacionRepository.save(publicacion);
        return mapearAResponseDTO(creada);
    }

    public List<PublicacionResponseDTO> listarPublicaciones() {
        return publicacionRepository.findAll()
                .stream()
                .map(this::mapearAResponseDTO)
                .toList();
    }

    public List<PublicacionResponseDTO> listarPorAutor(String autorId) {
        return publicacionRepository.findByAutorIdOrderByFechaDesc(autorId)
                .stream()
                .map(this::mapearAResponseDTO)
                .toList();
    }

    public PublicacionResponseDTO agregarComentario(String publicacionId, ComentarioRequestDTO datos) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new NoSuchElementException("No existe una publicación con id " + publicacionId));

        Comentario comentario = new Comentario(datos.autorNombre(), datos.texto(), LocalDateTime.now());
        publicacion.getComentarios().add(comentario);

        Publicacion actualizada = publicacionRepository.save(publicacion);
        return mapearAResponseDTO(actualizada);
    }

    private PublicacionResponseDTO mapearAResponseDTO(Publicacion publicacion) {
        List<ComentarioResponseDTO> comentariosDTO = publicacion.getComentarios()
                .stream()
                .map(c -> new ComentarioResponseDTO(c.getAutorNombre(), c.getTexto(), c.getFecha()))
                .toList();

        return new PublicacionResponseDTO(
                publicacion.getId(),
                publicacion.getAutorId(),
                publicacion.getTitulo(),
                publicacion.getContenido(),
                publicacion.getFecha(),
                comentariosDTO
        );
    }
}
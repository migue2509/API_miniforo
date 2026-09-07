package com.generation.miniforo.repository;

import com.generation.miniforo.model.Publicacion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends MongoRepository<Publicacion, String> {

    List<Publicacion> findByAutorIdOrderByFechaDesc(String autorId);
}
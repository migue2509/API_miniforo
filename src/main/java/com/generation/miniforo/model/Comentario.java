package com.generation.miniforo.model;

import java.time.LocalDateTime;

public class Comentario {

    private String autorNombre;

    private String texto;

    private LocalDateTime fecha;

    public Comentario() {
    }

    public Comentario(String autorNombre, String texto, LocalDateTime fecha) {
        this.autorNombre = autorNombre;
        this.texto = texto;
        this.fecha = fecha;
    }

    public String getAutorNombre() {
        return autorNombre;
    }

    public void setAutorNombre(String autorNombre) {
        this.autorNombre = autorNombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
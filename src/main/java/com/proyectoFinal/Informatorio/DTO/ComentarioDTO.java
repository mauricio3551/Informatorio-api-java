package com.proyectoFinal.Informatorio.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyectoFinal.Informatorio.Entity.Comentario;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComentarioDTO {

    private Long Id;
    private String comentario;
    private LocalDate fechaCreacion;

    public ComentarioDTO(Comentario comentario){
        this.Id = comentario.getId();
        this.comentario = comentario.getComentario();
    }

    public ComentarioDTO(Long id, String comentario, LocalDate fechaCreacion){
        this.Id = id;
        this.comentario = comentario;
        this.fechaCreacion = fechaCreacion;
    }

    public ComentarioDTO(Long id){
        Id = id;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}

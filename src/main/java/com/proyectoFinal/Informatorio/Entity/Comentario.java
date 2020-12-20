package com.proyectoFinal.Informatorio.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaCreacion = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonBackReference(value = "usuarioComentario")
    private Usuario comentario_usuario;


    @NotBlank(message = "Es necesario un comentario")
    @Size(max = 200)
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonBackReference(value = "comentarioPost")
    private Post post;

    public Comentario(Long id) {
        this.id = id;
    }

    public Comentario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getComentario_usuario() {
        return comentario_usuario;
    }

    public void setComentario_usuario(Usuario comentario_usuario) {
        this.comentario_usuario = comentario_usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}

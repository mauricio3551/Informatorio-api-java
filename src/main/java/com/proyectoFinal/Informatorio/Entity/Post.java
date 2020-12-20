package com.proyectoFinal.Informatorio.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere un titulo")
    private String titulo;

    @Column(nullable = false)
    @NotBlank(message = "Se requiere una descripcion")
    private String descripcion;

    @NotBlank(message = "Debe existir contenido")
    private String contenido;

    private LocalDate fechaCreacion = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonBackReference(value = "postReference")
    private Usuario autor;

    private boolean publicado;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "comentarioPost")
    private List<Comentario> comentario = new ArrayList<>();

    public Post(Long id) {
        this.id = id;
    }

    public Post(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public boolean isPublicado() {
        return publicado;
    }

    public void setPublicado(boolean publicado) {
        this.publicado = publicado;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }
}

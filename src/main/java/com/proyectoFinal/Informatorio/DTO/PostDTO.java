package com.proyectoFinal.Informatorio.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyectoFinal.Informatorio.Entity.Comentario;
import com.proyectoFinal.Informatorio.Entity.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;
    private UsuarioDTO usuarioDto;
    private LocalDate fechaCreacion;
    private Boolean publicado;
    private List<ComentarioDTO> comentarioDto;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.titulo = post.getTitulo();
        this.descripcion = post.getDescripcion();
        this.contenido = post.getContenido();
        this.usuarioDto = new UsuarioDTO(post.getAutor());
        this.fechaCreacion = post.getFechaCreacion();
        this.publicado = post.isPublicado();
        this.comentarioDto = post.getComentario().stream()
                .map((Comentario comentarioDto) -> new ComentarioDTO(
                        comentarioDto.getId(), comentarioDto.getComentario(),
                        comentarioDto.getFechaCreacion())).collect(Collectors.toList());
    }

    public PostDTO(Long id, String titulo, String descripcion, String contenido, UsuarioDTO usuarioDTO, LocalDate fechaCreacion, boolean publicado, List<ComentarioDTO> comentarioDTO) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.usuarioDto = usuarioDTO;
        this.fechaCreacion = fechaCreacion;
        this.publicado = publicado;
        this.comentarioDto = comentarioDTO;
    }

    public PostDTO(Long id, String titulo, String descripcion, String contenido, UsuarioDTO usuarioDTO, LocalDate fechaCreacion, boolean publicado){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
        this.usuarioDto = usuarioDTO;
        this.fechaCreacion = fechaCreacion;
        this.publicado = publicado;
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

    public UsuarioDTO getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDTO usuarioDto) {
        this.usuarioDto = usuarioDto;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getPublicado() {
        return publicado;
    }

    public void setPublicado(Boolean publicado) {
        this.publicado = publicado;
    }

    public List<ComentarioDTO> getCommentDto() {
        return comentarioDto;
    }

    public void setCommentDto(List<ComentarioDTO> commentDto) {
        this.comentarioDto = commentDto;
    }
}

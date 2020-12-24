package com.proyectoFinal.Informatorio.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyectoFinal.Informatorio.Entity.Comentario;
import com.proyectoFinal.Informatorio.Entity.Post;
import com.proyectoFinal.Informatorio.Entity.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaCreacion;
    private String ciudad;
    private String provincia;
    private String pais;
    private List<PostDTO> postDto;
    private List<ComentarioDTO> comentarioDto;

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.fechaCreacion = usuario.getFechaCreacion();
        this.ciudad = usuario.getCiudad();
        this.provincia = usuario.getProvincia();
        this.pais = usuario.getPais();
        this.postDto = tomarPost(usuario);
        this.comentarioDto = usuario.getComentario().stream()
                .map((Comentario comentarioDto) -> new ComentarioDTO(
                        comentarioDto.getId(), comentarioDto.getComentario(),
                        comentarioDto.getFechaCreacion())).collect(Collectors.toList());
    }

    private List<PostDTO> tomarPost(Usuario usuario){
        return usuario.getPost().stream()
                .map((Post postDto) -> new PostDTO(postDto.getId(),
                        postDto.getTitulo(),postDto.getDescripcion(),
                        postDto.getContenido(),
                        new UsuarioDTO(postDto.getAutor().getId()),
                        postDto.getFechaCreacion(),postDto.isPublicado(),
                        postDto.getComentario().stream()
                                .map(ComentarioDTO::new).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public UsuarioDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<PostDTO> getPost() {
        return postDto;
    }

    public void setPost(List<PostDTO> postDto) {
        this.postDto = postDto;
    }

    public List<ComentarioDTO> getComentario() {
        return comentarioDto;
    }

    public void setComentario(List<ComentarioDTO> comentarioDto) {
        this.comentarioDto = comentarioDto;
    }
}

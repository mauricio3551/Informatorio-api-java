package com.proyectoFinal.Informatorio.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.proyectoFinal.Informatorio.Entity.Comentario;
import com.proyectoFinal.Informatorio.Entity.Post;
import com.proyectoFinal.Informatorio.Entity.Usuario;

import java.time.LocalDate;
import java.util.List;

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
    private List<PostDTO> post;
    private List<ComentarioDTO> comentario;

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellido = usuario.getApellido();
        this.email = usuario.getEmail();
        this.fechaCreacion = usuario.getFechaCreacion();
        this.ciudad = usuario.getCiudad();
        this.provincia = usuario.getProvincia();
        this.pais = usuario.getPais();

    }
}

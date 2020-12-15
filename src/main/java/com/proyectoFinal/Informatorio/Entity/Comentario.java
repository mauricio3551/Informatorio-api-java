package com.proyectoFinal.Informatorio.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @NotBlank(message = "Debe existir un autor")
    private Usuario Autor;
    private Date fechaCreacion;
    @Size(max = 200)
    private String comentario;
}

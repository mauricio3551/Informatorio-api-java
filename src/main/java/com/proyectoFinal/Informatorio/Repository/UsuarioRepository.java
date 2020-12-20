package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("FROM Usuario WHERE ciudad LIKE 'Resistencia'")
    List <Usuario> encontrarUsuarioPorCiudad();

    @Query("FROM Usuario WHERE fechaCreacion >= ?1")
    List <Usuario> encontrarUsuarioPorFecha(LocalDate date);
}

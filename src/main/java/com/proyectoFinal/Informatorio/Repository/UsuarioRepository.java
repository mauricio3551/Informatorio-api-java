package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("FROM Usuario WHERE ciudad LIKE 'Resistencia'")
    List <Usuario> encontrarUsuarioPorCiudad();

    @Modifying
    @Transactional
    @Query("FROM Usuario WHERE fechaCreacion >= :fecha")
    List <Usuario> encontrarUsuarioPorFecha(@Param("fecha") Date date);
}

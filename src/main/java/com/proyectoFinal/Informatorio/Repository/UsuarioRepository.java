package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

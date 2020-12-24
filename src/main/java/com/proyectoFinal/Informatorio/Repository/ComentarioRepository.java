package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    @Query(value="FROM Comentario WHERE post_id = ?1 LIMIT ?2", nativeQuery = true)
    List<Comentario> comentarioByPostId(Long post_id, Integer num);

}

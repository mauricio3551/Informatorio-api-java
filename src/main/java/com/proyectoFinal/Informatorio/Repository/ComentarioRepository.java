package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    @Query(value="SELECT * FROM Comentario WHERE post_id = :post_id ORDER BY id DESC LIMIT :lim", nativeQuery = true)
    List<Comentario> comentarioByPostId(@Param("post_id") Long post_id, @Param("lim") Integer num);

}

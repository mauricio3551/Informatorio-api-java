package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("FROM Post WHERE titulo LIKE %:palabra%")
    List<Post> buscarPost(@Param("palabra") String palabra);

    @Query("FROM Post WHERE publicado = false")
    List<Post> postNoPublicados();
}

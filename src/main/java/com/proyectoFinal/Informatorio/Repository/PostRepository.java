package com.proyectoFinal.Informatorio.Repository;

import com.proyectoFinal.Informatorio.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}

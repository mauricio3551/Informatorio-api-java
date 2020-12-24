package com.proyectoFinal.Informatorio.Service;

import com.proyectoFinal.Informatorio.DTO.PostDTO;
import com.proyectoFinal.Informatorio.Entity.Post;
import com.proyectoFinal.Informatorio.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO crearPost(Post nuevoPost){
        return new PostDTO(postRepository.save(nuevoPost));
    }

    public List<PostDTO> buscarTodosPost(){
        return postRepository.findAll().stream().map(PostDTO::new).collect(Collectors.toList());
    }

    public Post getPost(Long idPost){
        return postRepository.getOne(idPost);
    }

    public PostDTO updatePost(Post newPost){
        return new PostDTO(postRepository.save(newPost));
    }

    public void eliminarUnPost(Post post){
        postRepository.delete(post);
    }

    public List<Post> postConPalabra(String palabra){
        return postRepository.buscarPost(palabra);
    }

    public List<Post> buscarPostNoPublicados(){
        return postRepository.postNoPublicados();
    }
}

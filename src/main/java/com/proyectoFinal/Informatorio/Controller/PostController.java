package com.proyectoFinal.Informatorio.Controller;

import com.proyectoFinal.Informatorio.Entity.Post;
import com.proyectoFinal.Informatorio.Entity.Usuario;
import com.proyectoFinal.Informatorio.Repository.PostRepository;
import com.proyectoFinal.Informatorio.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    //Llama a todos los post
    @GetMapping("api/v1/post")
    public ResponseEntity<?> getPost(){
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    //Crea un nuevo post
    @PostMapping("api/v1/post")
    public ResponseEntity<?> createPost(@RequestBody Post post){
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    //Modificar post
    @PutMapping ("api/v1/post/{id}/modificar")
    public ResponseEntity<?> modificarPost(@RequestParam String titulo, @RequestParam String descripcion, @RequestParam String contenido, @PathVariable ("id") Long id){
        Optional<Post> postViejo = postRepository.findById(id);
        Post postNuevo = postViejo.get();
        postNuevo.setId(id);
        postNuevo.setTitulo(titulo);
        postNuevo.setDescripcion(descripcion);
        postNuevo.setContenido(contenido);
        postNuevo.setFechaCreacion(postViejo.get().getFechaCreacion());
        postNuevo.setAutor(postViejo.get().getAutor());
        postNuevo.setPublicado(postViejo.get().isPublicado());
        postNuevo.setComentario(postViejo.get().getComentario());

        return new ResponseEntity<>(postRepository.save(postNuevo),HttpStatus.CREATED);
    }




}

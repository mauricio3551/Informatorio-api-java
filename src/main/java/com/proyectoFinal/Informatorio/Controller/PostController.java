package com.proyectoFinal.Informatorio.Controller;

import com.proyectoFinal.Informatorio.Entity.Post;
import com.proyectoFinal.Informatorio.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    //Llama a todos los post
    @GetMapping("api/v1/post")
    public ResponseEntity<?> getPost(){
        return new ResponseEntity<>(postService.buscarTodosPost(), HttpStatus.OK);
    }

    //Crea un nuevo post
    @PostMapping("api/v1/post")
    public ResponseEntity<?> createPost(@RequestBody Post post){
        return new ResponseEntity<>(postService.crearPost(post), HttpStatus.CREATED);
    }

    //Modificar post
    @PutMapping ("api/v1/post/{id}/modificar")
    public ResponseEntity<?> modificarPost(@RequestBody Post post, @PathVariable ("id") Long id){
        Post postNuevo = postService.getPost(id);
        postNuevo.setId(id);
        postNuevo.setTitulo(post.getTitulo());
        postNuevo.setDescripcion(post.getDescripcion());
        postNuevo.setContenido(post.getContenido());
        postNuevo.setFechaCreacion(post.getFechaCreacion());

        return new ResponseEntity<>(postService.updatePost(postNuevo),HttpStatus.CREATED);
    }

    @DeleteMapping("api/v1/post/{id}/eliminar")
    public HttpStatus eliminarPost(@PathVariable("id") Long id){
        Post posteo = postService.getPost(id);
        if (posteo.getContenido().isBlank()){
            return HttpStatus.NO_CONTENT;
        }
        postService.eliminarUnPost(posteo);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("api/v1/post/palabra")
    public ResponseEntity<?> buscarPostConPalabra(@RequestParam String palabra){
        return new ResponseEntity<>(postService.postConPalabra(palabra),HttpStatus.OK);
    }

    @GetMapping("api/v1/post/no_publicado")
    public ResponseEntity<?> buscarPostNoPublicado(@RequestParam Boolean publi){
        return new ResponseEntity<>(postService.buscarPostNoPublicados(),HttpStatus.OK);
    }





}

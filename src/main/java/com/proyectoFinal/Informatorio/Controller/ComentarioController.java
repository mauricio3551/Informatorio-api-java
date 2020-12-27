package com.proyectoFinal.Informatorio.Controller;

import com.proyectoFinal.Informatorio.Entity.Comentario;
import com.proyectoFinal.Informatorio.Repository.ComentarioRepository;
import com.proyectoFinal.Informatorio.Service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("api/v1/comentario")
    public ResponseEntity<?> getComentario(){
        return new ResponseEntity<>(comentarioService.getComentario(), HttpStatus.OK);
    }

    @PostMapping("api/v1/comentario")
    public ResponseEntity<?> createComentario(@RequestBody Comentario comentario){
        return new ResponseEntity<>(comentarioService.crearComentario(comentario), HttpStatus.CREATED);
    }

    @PutMapping("api/avi/comentario/{id}/modificar")
    public ResponseEntity<?> modificarController(@RequestBody Comentario comentario, @PathVariable ("id") Long id){
        Comentario comentarioNuevo = comentarioService.encontrarComentario(id);
        comentarioNuevo.setId(id);
        comentarioNuevo.setFechaCreacion(comentario.getFechaCreacion());
        comentarioNuevo.setComentario(comentario.getComentario());

        return new ResponseEntity<>(comentarioService.updateComentario(comentarioNuevo),HttpStatus.CREATED);
    }

    @DeleteMapping("api/v1/comentario/{id}/eliminar")
    public HttpStatus eliminarComentario(@PathVariable ("id") Long id){
        Comentario comment = comentarioService.encontrarComentario(id);
        if (comment.getComentario().isBlank()){
            return HttpStatus.NO_CONTENT;
        }
        comentarioService.eliminarUnComentario(comment);
        return HttpStatus.ACCEPTED;
    }

    @GetMapping("api/v1/comentario/{id}")
    public ResponseEntity<?> tomarComentariosDePost(@RequestParam Long idPost, @RequestParam(required = false, defaultValue = "99999999") Integer numero){
        return new ResponseEntity<>(comentarioService.getComentariosEnPost(idPost, numero), HttpStatus.OK);
    }

}

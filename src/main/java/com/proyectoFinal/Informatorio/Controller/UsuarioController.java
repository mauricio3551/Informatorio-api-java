package com.proyectoFinal.Informatorio.Controller;

import com.proyectoFinal.Informatorio.Entity.Usuario;
import com.proyectoFinal.Informatorio.Repository.PostRepository;
import com.proyectoFinal.Informatorio.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("api/v1/usuario")
    public ResponseEntity<?> getUsuario(){
        return new ResponseEntity<>(usuarioRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("api/v1/usuario")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioRepository.save(usuario), HttpStatus.CREATED);
    }

    //Modifica un usuario
    @PutMapping("api/v1/usuario/modificar/{id}")
    public ResponseEntity<?> modificarUsuario (@RequestBody Usuario usuario, @PathVariable("id") Long id){
        Optional<Usuario> usuarioViejo = usuarioRepository.findById(id);

        return new ResponseEntity<>(pos)
    }

}

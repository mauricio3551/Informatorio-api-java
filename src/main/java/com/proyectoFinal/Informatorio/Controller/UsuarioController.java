package com.proyectoFinal.Informatorio.Controller;

import com.proyectoFinal.Informatorio.Entity.Usuario;
import com.proyectoFinal.Informatorio.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @PutMapping("api/v1/usuario/{id}/modificar")
    public ResponseEntity<?> modificarUsuario (@RequestBody Usuario usuario, @PathVariable ("id") Long id){
        Optional<Usuario> usuarioViejo = usuarioRepository.findById(id);
        Usuario usuarioNuevo = usuarioViejo.get();
        usuarioNuevo.setId(id);
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido(usuario.getApellido());
        usuarioNuevo.setEmail(usuario.getEmail());
        usuarioNuevo.setPassword(usuario.getPassword());
        usuarioNuevo.setFechaCreacion(usuario.getFechaCreacion());
        usuarioNuevo.setCiudad(usuario.getCiudad());
        usuarioNuevo.setProvincia(usuario.getProvincia());
        usuarioNuevo.setPais(usuario.getPais());

        return new ResponseEntity<>(usuarioRepository.save(usuarioNuevo),HttpStatus.CREATED);
    }

    //Eliminar un usuario
    @DeleteMapping("api/v1/usuario/{id}/eliminar")
    public HttpStatus eliminarUsuario(@PathVariable ("id") Long id){
        Optional<Usuario> user = usuarioRepository.findById(id);
        if (!(user.isPresent())){
            return HttpStatus.NO_CONTENT;
        }
        usuarioRepository.deleteById(id);
        return HttpStatus.ACCEPTED;
    }

    //Buscar por ciudad RESISTENCIA
    @GetMapping("api/v1/usuario/buscar/ciudad/resistencia")
    public ResponseEntity<?> buscarUsuarioResistencia(){
        return new ResponseEntity<>(usuarioRepository.encontrarUsuarioPorCiudad(),HttpStatus.OK);
    }

    //Buscar desde una fecha
    @GetMapping("api/v1/usuario/buscar/fecha")
    public ResponseEntity<?> buscarUsuarioFecha(@RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(usuarioRepository.encontrarUsuarioPorFecha(date),HttpStatus.OK);
    }

}

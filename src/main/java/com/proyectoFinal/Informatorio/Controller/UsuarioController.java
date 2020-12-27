package com.proyectoFinal.Informatorio.Controller;

import com.proyectoFinal.Informatorio.Entity.Usuario;
import com.proyectoFinal.Informatorio.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("api/v1/usuario")
    public ResponseEntity<?> getUsuario(){
        return new ResponseEntity<>(usuarioService.buscarUsuario(), HttpStatus.OK);
    }

    @PostMapping("api/v1/usuario")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }

    //Modifica un usuario
    @PutMapping("api/v1/usuario/{id}/modificar")
    public ResponseEntity<?> modificarUsuario (@RequestBody Usuario usuario, @PathVariable ("id") Long id){
        Usuario usuarioNuevo = usuarioService.tomarUnUsuario(id);
        usuarioNuevo.setId(id);
        usuarioNuevo.setNombre(usuario.getNombre());
        usuarioNuevo.setApellido(usuario.getApellido());
        usuarioNuevo.setEmail(usuario.getEmail());
        usuarioNuevo.setPassword(usuario.getPassword());
        usuarioNuevo.setFechaCreacion(usuario.getFechaCreacion());
        usuarioNuevo.setCiudad(usuario.getCiudad());
        usuarioNuevo.setProvincia(usuario.getProvincia());
        usuarioNuevo.setPais(usuario.getPais());

        return new ResponseEntity<>(usuarioService.updateUsuario(usuarioNuevo),HttpStatus.CREATED);
    }

    //Eliminar un usuario
    @DeleteMapping("api/v1/usuario/{id}/eliminar")
    public HttpStatus eliminarUsuario(@PathVariable ("id") Long id){
        Usuario user = usuarioService.tomarUnUsuario(id);
        if (user.getNombre().isBlank()){
            return HttpStatus.NO_CONTENT;
        }
        usuarioService.eliminarUnUsuario(user);
        return HttpStatus.ACCEPTED;
    }

    //Buscar por ciudad RESISTENCIA
    @GetMapping("api/v1/usuario/buscar/ciudad/resistencia")
    public ResponseEntity<?> buscarUsuarioResistencia(){
        return new ResponseEntity<>(usuarioService.usuarioPorCiudad(),HttpStatus.OK);
    }

    //Buscar desde una fecha
    @GetMapping("api/v1/usuario/buscar/fecha")
    public ResponseEntity<?> buscarUsuarioFecha(@RequestParam @DateTimeFormat (iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(usuarioService.buscasUsuarioPorFechaCreacion(date),HttpStatus.OK);
    }

}

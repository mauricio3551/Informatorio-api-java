package com.proyectoFinal.Informatorio.Service;

import com.proyectoFinal.Informatorio.DTO.UsuarioDTO;
import com.proyectoFinal.Informatorio.Entity.Usuario;
import com.proyectoFinal.Informatorio.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO crearUsuario(Usuario nuevoUsuario){
        return new UsuarioDTO(usuarioRepository.save(nuevoUsuario));
    }

    public List<UsuarioDTO> buscarUsuario(){
        return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public Usuario tomarUnUsuario(Long idUsuario){
        return usuarioRepository.getOne(idUsuario);
    }

    public UsuarioDTO updateUsuario(Usuario newUsuario){
        return new UsuarioDTO(usuarioRepository.save(newUsuario));
    }

    public void eliminarUnUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> usuarioPorCiudad(){
        return usuarioRepository.encontrarUsuarioPorCiudad();
    }

    public List<Usuario> buscasUsuarioPorFechaCreacion(LocalDate fecha){
        return usuarioRepository.encontrarUsuarioPorFecha(fecha);
    }
}

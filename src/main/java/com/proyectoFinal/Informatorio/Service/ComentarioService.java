package com.proyectoFinal.Informatorio.Service;

import com.proyectoFinal.Informatorio.DTO.ComentarioDTO;
import com.proyectoFinal.Informatorio.Entity.Comentario;
import com.proyectoFinal.Informatorio.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public ComentarioDTO crearComentario(Comentario comentario){
        return new ComentarioDTO(comentarioRepository.save(comentario));
    }

    public List<ComentarioDTO> getComentario(){
        return comentarioRepository.findAll().stream().map(ComentarioDTO::new).collect(Collectors.toList());
    }

    public Comentario encontrarComentario(Long idComentario){
        return comentarioRepository.getOne(idComentario);
    }

    public ComentarioDTO updateComentario(Comentario newComentario){
        return new ComentarioDTO(comentarioRepository.save(newComentario));
    }

    public void eliminarUnComentario(Comentario comentario){
        comentarioRepository.delete(comentario);
    }




}

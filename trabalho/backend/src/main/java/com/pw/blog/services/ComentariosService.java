package com.pw.blog.services;

import com.pw.blog.model.Comentarios;
import com.pw.blog.model.Post;
import com.pw.blog.model.Usuario;
import com.pw.blog.repository.ComentariosRepository;
import com.pw.blog.repository.PostRepository;
import org.hibernate.annotations.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class ComentariosService {

    @Autowired
    ComentariosRepository comentariosRepository;

    @Autowired
    PostRepository postRepository;

    public List<Comentarios> listarTodos(){

        return comentariosRepository.findAll();
    }

    public List<Comentarios> listarPorPost(Long id){

        return comentariosRepository.findAllByPost_Id(id);

    }

    public Comentarios cadastrar(Comentarios comentarios){

        LocalDate data = LocalDate.now();

        comentarios.setDataCriacao(data);

        return comentariosRepository.save(comentarios);
    }

    public Comentarios editar(Comentarios comentarios){

        return comentariosRepository.save(comentarios);
    }

    public void deletar(Long id){

        Comentarios comentarios = comentariosRepository.findFirstById(id);

        comentariosRepository.delete(comentarios);
    }
}

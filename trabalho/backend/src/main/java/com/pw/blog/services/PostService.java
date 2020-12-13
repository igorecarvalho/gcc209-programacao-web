package com.pw.blog.services;

import com.pw.blog.model.Post;
import com.pw.blog.model.Usuario;
import com.pw.blog.repository.PostRepository;
import com.pw.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Post> listarTodos(){

        return postRepository.findAll();
    }

    public List<Post> listarPorUsuario(Long idUsuario){

        Usuario usuario = usuarioRepository.findFirstById(idUsuario);
        return postRepository.findAllByUsuario(usuario);
    }

    public Post cadastrar(Post post){

        return postRepository.save(post);
    }

    public Post editar(Post post){

        return postRepository.save(post);
    }

    public void deletar(Long id){

        Post post = postRepository.findFirstById(id);

        postRepository.delete(post);
    }
}

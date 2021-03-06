package com.pw.blog.services;

import com.pw.blog.model.Comentarios;
import com.pw.blog.model.Post;
import com.pw.blog.model.Usuario;
import com.pw.blog.repository.PostRepository;
import com.pw.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ComentariosService comentariosService;

    public List<Post> listarTodos(){

        return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public List<Post> listarPorUsuario(Long idUsuario){

        Usuario usuario = usuarioRepository.findFirstById(Sort.by(Sort.Direction.DESC, "id"), idUsuario);
        return postRepository.findAllByUsuario(Sort.by(Sort.Direction.DESC, "id"), usuario);
    }

    public Post cadastrar(Post post){

        LocalDate data = LocalDate.now();

        post.setDataCriacao(data);

        return postRepository.save(post);
    }

    public Post getPost(Long id){

        return postRepository.findFirstById(id);
    }

    public Post editar(Post post){

        return postRepository.save(post);
    }

    public void deletar(Long id){

        Post post = postRepository.findFirstById(id);

        for (Comentarios comentario: comentariosService.listarPorPost(id)) {
            comentariosService.deletar(comentario.getId());
        }
        postRepository.delete(post);
    }
}

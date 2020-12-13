package com.pw.blog.repository;

import com.pw.blog.model.Post;
import com.pw.blog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{

    Post findFirstById(Long id);

    List<Post> findAllByUsuario(Usuario usuario);
}

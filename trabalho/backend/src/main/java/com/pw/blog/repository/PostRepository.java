package com.pw.blog.repository;

import com.pw.blog.model.Post;
import com.pw.blog.model.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>{

    Post findFirstById(Sort by, Long id);

    List<Post> findAllByUsuario(Sort id, Usuario usuario);

    Post findFirstById(Long id);
}

package com.pw.blog.repository;


import com.pw.blog.model.Comentarios;
import com.pw.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComentariosRepository  extends JpaRepository<Comentarios, Long> {

    Comentarios findFirstById(Long id);

    List<Comentarios> findAllByPost_Id(Long id);
}

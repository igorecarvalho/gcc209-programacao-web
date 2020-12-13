package com.pw.blog.repository;

import com.pw.blog.model.Comentarios;
import com.pw.blog.model.Grupo;
import com.pw.blog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {

    Grupo findFirstById(Long id);

    List<Grupo> findByUsuariosIn(List<Usuario> usuario);

}
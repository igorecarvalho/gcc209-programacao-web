package com.pw.blog.repository;

import com.pw.blog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);

    Usuario findFirstById(Long id);
}
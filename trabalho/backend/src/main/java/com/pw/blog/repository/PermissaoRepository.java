package com.pw.blog.repository;

import com.pw.blog.model.Grupo;
import com.pw.blog.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    Permissao findFirstById(Long id);

    List<Permissao> findByGruposIn(List<Grupo> grupo);

}
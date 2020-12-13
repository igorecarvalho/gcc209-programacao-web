package com.pw.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="GRUPO", schema = "trabalho_gcc209")
public class Grupo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @OneToMany
    private List<Usuario> usuarios;

    @ManyToOne
    private Permissao permissoes;

}
package com.pw.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="PERMISSAO", schema = "trabalho_gcc209")
public class Permissao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    private List<Usuario> usuarios;

    @OneToMany
    private List<Grupo> grupos;

    public String getNome() {
        return nome;
    }
}
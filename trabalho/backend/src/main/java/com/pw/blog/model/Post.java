package com.pw.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="POSTAGEM", schema = "trabalho_gcc209")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    private String mensagem;

    private String fileName;

    @ManyToOne
    private Usuario usuario;

    public Post() {
    }
}

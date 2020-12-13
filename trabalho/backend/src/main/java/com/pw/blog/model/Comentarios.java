package com.pw.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="COMENTARIOS", schema = "trabalho_gcc209")
public class Comentarios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mensagem;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Post post;

}

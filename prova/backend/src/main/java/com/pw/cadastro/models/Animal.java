package com.pw.cadastro.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "ANIMAL", schema = "prova_gcc209")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_animal")
    private String nomeAnimal;

    @Column(name = "tipo_animal")
    private String tipoAnimal;

    @Column(name = "idade_animal")
    public Integer idadeAnimal;

}

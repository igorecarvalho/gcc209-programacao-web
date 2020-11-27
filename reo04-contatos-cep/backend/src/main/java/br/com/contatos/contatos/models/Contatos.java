package br.com.contatos.contatos.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name="CONTATOS", schema="agenda_gcc209")
@Getter
@Setter
public class Contatos implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "{validacao.notnull}")
    @NotBlank(message = "{validacao.notBlank}")
    @Column(name="nome_contato")
    private String nomeContato;

    @NotNull(message = "{validacao.notnull}")
    @NotBlank(message = "{validacao.notBlank}")
    @Column(name="email_contato")
    private String emailContato;

    @NotNull(message = "{validacao.notnull}")
    @NotBlank(message = "{validacao.notBlank}")
    @Column(name="telefone_contato")
    private String telefoneContato;

    @Column(name="dataNascimento_contato")
    public String dataNascimentoContato;

    @Column(name="cep_contato")
    public String cepContato;

    @Column(name="logradouro_contato")
    public String logradouroContato;

    @Column(name="bairro_contato")
    public String bairroContato;

    @Column(name="localidade_contato")
    public String localidadeContato;

    @Column(name="uf_contato")
    public String ufContato;

    @Column(name="facebook_contato")
    public String facebookContato;

    @Column(name="linkedin_contato")
    public String linkedinContato;

    @Column(name="twitter_contato")
    public String twitterContato;

    @Column(name="instagram_contato")
    public String instagramContato;

}

package com.pw.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Getter
@Setter
@Table(name="USUARIO", schema = "trabalho_gcc209")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String login;

    private String senha;

    public String cep;

    public String logradouro;

    public String bairro;

    public String localidade;

    public String uf;

    @OneToMany
    private List<Post> postagens;

    @OneToMany
    private List<Comentarios> comentarios;

    @ManyToOne
    private Grupo grupo;

    @ManyToOne
    private Permissao permissao;

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        this.senha = encoder.encode(senha);
        this.senha = senha;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
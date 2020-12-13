package com.pw.blog.services;

import com.pw.blog.model.Grupo;
import com.pw.blog.model.Permissao;
import com.pw.blog.model.Usuario;
import com.pw.blog.repository.GrupoRepository;
import com.pw.blog.repository.PermissaoRepository;
import com.pw.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    GrupoRepository grupoRepository;

    @Autowired
    PermissaoRepository permissaoRepository;

    public List<Usuario> listar(){

        return usuarioRepository.findAll();
    }

    public Usuario cadastrar(Usuario usuario){

        String senha = usuario.getSenha();
        usuario.setSenha(senha);

        Grupo grupo = grupoRepository.findFirstById((long)2);
        usuario.setGrupo(grupo);

        Permissao permissao = permissaoRepository.findFirstById((long)2);
        usuario.setPermissao(permissao);

        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(Long id){

        return usuarioRepository.findFirstById(id);
    }

    public Usuario editar(Usuario usuario){

        return usuarioRepository.save(usuario);
    }
}

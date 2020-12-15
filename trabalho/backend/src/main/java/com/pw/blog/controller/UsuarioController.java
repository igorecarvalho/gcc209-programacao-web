package com.pw.blog.controller;

import com.pw.blog.model.Comentarios;
import com.pw.blog.model.Usuario;
import com.pw.blog.repository.UsuarioRepository;
import com.pw.blog.security.MyUserDetailsService;
import com.pw.blog.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @CrossOrigin
    @GetMapping("/verificar")
    public UserDetails verificarAutorizacao(Usuario login){
        return myUserDetailsService.loadUserByUsername(login.getLogin());
    }

    @CrossOrigin
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listarTodos(){

        return new ResponseEntity<>(usuarioService.listar(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{idUsuario}/listar")
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable(value="idUsuario") Long idUsuario){

        return new ResponseEntity<>(usuarioService.getUsuario(idUsuario), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){

        return new ResponseEntity<>(usuarioService.cadastrar(usuario), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}/editar")
    public ResponseEntity<Usuario> editar(@RequestBody Usuario usuario){

        return new ResponseEntity<>(usuarioService.editar(usuario), HttpStatus.OK);
    }

}

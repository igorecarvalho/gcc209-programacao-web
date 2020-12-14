package com.pw.blog.controller;

import com.pw.blog.model.Comentarios;
import com.pw.blog.services.ComentariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    ComentariosService comentariosService;

    @CrossOrigin
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listarTodos(){

        return new ResponseEntity<>(comentariosService.listarTodos(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{idPost}/listar")
    public ResponseEntity<List> listarComentariosPorPost(@PathVariable(value="idPost") Long idPost){

        return new ResponseEntity<>(comentariosService.listarPorPost(idPost), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/cadastrar")
    public ResponseEntity<Comentarios> cadastrar(@RequestBody Comentarios comentario){

        return new ResponseEntity<>(comentariosService.cadastrar(comentario), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}/editar")
    public ResponseEntity<Comentarios> editar(@RequestBody Comentarios Comentarios){

        return new ResponseEntity<>(comentariosService.editar(Comentarios), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{idComentario}/deletar")
    public void deletar(@PathVariable(value="idComentario") Long idComentario ){

        comentariosService.deletar(idComentario);
    }
}

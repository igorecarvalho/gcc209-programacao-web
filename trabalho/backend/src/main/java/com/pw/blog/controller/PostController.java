package com.pw.blog.controller;

import com.pw.blog.model.Post;
import com.pw.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @CrossOrigin
    @GetMapping("/listarTodos")
    public ResponseEntity<List> listarTodos(){

        return new ResponseEntity<>(postService.listarTodos(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/get/{idPost}")
    public ResponseEntity<Post> getPost(@PathVariable(value="idPost") Long idPost){

        return new ResponseEntity<>(postService.getPost(idPost), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{idUsuario}/listar")
    public ResponseEntity<List> listarPostPorUsuario(@PathVariable(value="idUsuario") Long idUsuario){

        return new ResponseEntity<>(postService.listarPorUsuario(idUsuario), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("/cadastrar")
    public ResponseEntity<Post> cadastrar(@RequestBody Post post){

        return new ResponseEntity<>(postService.cadastrar(post), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/{id}/editar")
    public ResponseEntity<Post> editar(@RequestBody Post post){

        return new ResponseEntity<>(postService.editar(post), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{idPost}/deletar")
    public void deletar(@PathVariable(value="idPost") Long idPost ){

        postService.deletar(idPost);
    }

}

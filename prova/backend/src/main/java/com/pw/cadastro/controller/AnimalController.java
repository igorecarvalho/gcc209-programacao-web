package com.pw.cadastro.controller;

import com.pw.cadastro.interfaces.IAnimalService;
import com.pw.cadastro.models.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

    @Autowired
    IAnimalService animalService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Animal> cadastrar(@RequestBody Animal animal){

        return new ResponseEntity<>(animalService.cadastrar(animal), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List> listar(){

        return new ResponseEntity<>(animalService.listar(), HttpStatus.OK);
    }
}

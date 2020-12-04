package com.pw.cadastro.interfaces;

import com.pw.cadastro.models.Animal;

import java.util.List;

public interface IAnimalService {

    Animal cadastrar(Animal animal);

    List<Animal> listar();
}

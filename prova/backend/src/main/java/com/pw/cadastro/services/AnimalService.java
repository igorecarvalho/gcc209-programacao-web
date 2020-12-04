package com.pw.cadastro.services;

import com.pw.cadastro.interfaces.IAnimalService;
import com.pw.cadastro.models.Animal;
import com.pw.cadastro.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "*")
public class AnimalService implements IAnimalService {

    @Autowired
    AnimalRepository animalRepository;

    @Override
    public Animal cadastrar(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public List<Animal> listar() {
        return animalRepository.findAll();
    }
}

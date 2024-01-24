package group.zootopia.backend.service;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import group.zootopia.backend.models.Animal;
import group.zootopia.backend.repositories.AnimalRepository;
@Service

public class AnimalService {

    AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> getAll(){
        List<Animal> animals = animalRepository.findAll();
        return animals;
    }

    public Animal save(@NonNull Animal animal) {
        Animal newAnimal = animalRepository.save(animal);
        return newAnimal;
    }
    

    // Counter
    public long getAnimalCount() {
        long animalCount = animalRepository.count();
        return animalCount;
    }

    // Filter
    public List<Animal> getByFamily(String family) {
        List<Animal> animals = animalRepository.findByFamily(family);
        return animals;
    }
}

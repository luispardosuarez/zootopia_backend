package group.zootopia.backend.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import group.zootopia.backend.models.Animal;
import group.zootopia.backend.service.AnimalService;

@RestController
@RequestMapping(path = "${api-endpoint}/animals")
public class AnimalController {
    
    private AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping(path = "/all")
    public List<Animal> index() {
        return animalService.getAll();
    }
   
    // Filter
    @GetMapping(path = "/family")
    public List<Animal> filterByFamily(@RequestBody String family) {
        return animalService.getByFamily(family);
    }

    // Counter
    @GetMapping(path = "/count")
    public long getAnimalCount() {
        return animalService.getAnimalCount();
    }

    @PostMapping("/add")
    public ResponseEntity<Animal> create(@NonNull @RequestBody Animal animal) {
        Animal newAnimal = animalService.save(animal);
        return ResponseEntity.status(201).body(newAnimal);
    }

}

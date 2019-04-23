package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolBicycleController {
    private BicycleRepository repository;

    public CoolBicycleController(BicycleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cool-bicycles")
    public Collection<Bicycle> coolBicycles() {
        return repository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Bicycle bicycle) {
        return !bicycle.getName().equals("Scott") &&
                !bicycle.getName().equals("Bianchi") &&
                !bicycle.getName().equals("Cube") &&
                !bicycle.getName().equals("Pinarello") &&
                !bicycle.getName().equals("Fuji") &&
                !bicycle.getName().equals("Colnago");
    }
}
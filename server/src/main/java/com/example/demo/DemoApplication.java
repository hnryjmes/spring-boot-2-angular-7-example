package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(BicycleRepository repository) {
        return args -> {
            Stream.of("Trek", "Specialized", "Giant", "Scott", "Cannondale", "Bianchi", "Cube", "Pinarello", "Fuji", "Colnago").forEach(name -> {
                Bicycle bicycle = new Bicycle();
                bicycle.setName(name);
                repository.save(bicycle);
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}

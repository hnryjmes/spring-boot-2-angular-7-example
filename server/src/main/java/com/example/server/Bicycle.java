package com.example.server;

import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
public class Bicycle {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;
}

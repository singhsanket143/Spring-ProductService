package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Category {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}

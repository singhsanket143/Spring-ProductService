package com.example.productservice.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass // added because all child tables should have this, but no table for this should be created
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
}

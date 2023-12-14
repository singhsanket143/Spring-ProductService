package com.example.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product extends BaseModel {

    private String title;
    private String description;
    private String image;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}) // this makes sure that if product is deleted then price is also deleted
    private Price price;
    @ManyToOne // Category has many products, product belongs to a category
    private Category category;

}

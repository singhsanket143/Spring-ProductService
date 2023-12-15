package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice_PriceOrderByPrice_price(String title);

    List<Product> findAllByPrice_Currency(String currency);

    long countAllByPrice_Currency(String currency);

    List<Product> findAllByTitleLike(String titleRegex);
}

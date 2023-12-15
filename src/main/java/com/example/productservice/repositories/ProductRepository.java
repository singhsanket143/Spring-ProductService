package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import com.example.productservice.queries.ProductQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByTitleEquals(String title);

    Product findByTitleEqualsAndPrice_PriceOrderByPrice_price(String title);

    List<Product> findAllByPrice_Currency(String currency);

    long countAllByPrice_Currency(String currency);

    List<Product> findAllByTitleLike(String titleRegex);


    @Query(value = ProductQueries.FIND_ALL_BY_TITLE , nativeQuery = true)
    List<Product> findAllByTitle(String title);

    @Query("select Product from Product where Product.price.currency = :currency and Product.title = :title")
    List<Product> someOperation(String title, String currency);
}

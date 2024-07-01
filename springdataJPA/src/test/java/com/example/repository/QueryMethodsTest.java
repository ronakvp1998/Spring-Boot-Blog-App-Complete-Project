package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product 1");
        System.out.println("id: " + product.getId());
        System.out.println("name: " + product.getName());
        System.out.println("desc: " + product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }

    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("product 1","Product 3 desc");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("product 3","Product 3 desc");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod(){

        Product product = productRepository.findDistinctByName("product 1");
        System.out.println(product.getName()+" "+product.getId());
    }

    @Test
    void findByPriceGreaterThan(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p) -> {
            System.out.println(p.getName());
            System.out.println(p.getId());
        });
    }

    @Test
    void findByPriceLessThan(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach((p) -> {
            System.out.println(p.getPrice());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceLessThanEqual(){
        List<Product> products = productRepository.findByPriceLessThanEqual(new BigDecimal(200));
        products.forEach((p) -> {
            System.out.println(p.getPrice());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameContaining(){
        List<Product> products = productRepository.findByNameContaining("product 1");
        products.forEach((p)->{
            System.out.println(p.getName());
            System.out.println(p.getId());
        });
    }
}

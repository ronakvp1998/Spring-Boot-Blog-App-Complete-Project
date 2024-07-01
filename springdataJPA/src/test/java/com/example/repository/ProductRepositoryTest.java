package com.example.repository;

import com.example.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//@DataJpaTest
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("Product 1 desc");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        Product saveObject = productRepository.save(product);
        System.out.println(saveObject.getId());
        System.out.println(saveObject.toString());

    }

    @Test
    void updateUsingSaveMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
        product.setName("updated Product 1");
        product.setDescription("updated product 1 desc");
        productRepository.save(product);

    }

    @Test
    void findByIdMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();
    }

    @Test
    void saveAllMethod(){
        Product product = new Product();
        product.setName("product 2");
        product.setDescription("Product 2 desc");
        product.setSku("A");
        product.setPrice(new BigDecimal(200));
        product.setActive(true);
        product.setImageUrl("product2.png");

        Product product2 = new Product();
        product2.setName("product 3");
        product2.setDescription("Product 3 desc");
        product2.setSku("B");
        product2.setPrice(new BigDecimal(230));
        product2.setActive(true);
        product2.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product,product2));

    }

    @Test
    void findAllMethod(){

        List<Product> productList = productRepository.findAll();
        productList.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){
        Long id = 2L;
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){
//        productRepository.deleteAll();

        Product product = productRepository.findById(5L).get();
        Product product1 = productRepository.findById(6L).get();
        productRepository.deleteAll(List.of(product,product1));
    }

    @Test
    void countMethod(){
        Long count = productRepository.count();
        System.out.println(count);
    }




}
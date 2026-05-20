package org.example.ptit_cntt1_it211_session05_ex3.controller;

import jakarta.validation.Valid;
import org.example.ptit_cntt1_it211_session05_ex3.entity.Product;
import org.example.ptit_cntt1_it211_session05_ex3.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {

        Product savedProduct = productService.createProduct(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProduct);
    }
}

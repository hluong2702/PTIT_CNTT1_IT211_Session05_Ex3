package org.example.ptit_cntt1_it211_session05_ex3.repository;

import org.example.ptit_cntt1_it211_session05_ex3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

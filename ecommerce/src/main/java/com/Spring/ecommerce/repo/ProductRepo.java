package com.Spring.ecommerce.repo;

import com.Spring.ecommerce.model.Product;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query("""
            SELECT p FROM Product p WHERE
            LOWER(p.name) LIKE %:keyword% OR
            LOWER(p.description) LIKE %:keyword% OR
            LOWER(p.brand) LIKE %:keyword% OR
            LOWER(p.category) LIKE %:keyword%
            """)
    List<Product> searchProducts(String keyword);
}

package com.ecommerce.pharmacy.DAO;

import com.ecommerce.pharmacy.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findBySubCategoryId(Long subCategoryId);
    Product getProductByName(String productName);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> getProductsByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :prefix%")
    List<Product> getProductsByNameStartsWith(String prefix);
}

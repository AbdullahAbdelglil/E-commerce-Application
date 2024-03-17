package com.ecommerce.pharmacy.DAO;

import com.ecommerce.pharmacy.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category getCategoryByTitle(String title);
}

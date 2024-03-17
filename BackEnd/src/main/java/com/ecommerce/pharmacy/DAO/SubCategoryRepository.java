package com.ecommerce.pharmacy.DAO;

import com.ecommerce.pharmacy.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    SubCategory getSubCategoryById(Long id);
    SubCategory getSubCategoryByTitle(String title);
}

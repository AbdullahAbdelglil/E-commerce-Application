package com.ecommerce.pharmacy.service;

import com.ecommerce.pharmacy.Entity.Product;
import com.ecommerce.pharmacy.Entity.SubCategory;

import java.util.List;

public interface SubCategoryService {
    SubCategory addSubCategory(Long categoryId, SubCategory subCategory);
    void addProducts(Long subCategoryId, List<Product> productList);
    SubCategory getSubCategory(Long id);
    SubCategory getSubCategory(String title);

    List<SubCategory> getAll();
}

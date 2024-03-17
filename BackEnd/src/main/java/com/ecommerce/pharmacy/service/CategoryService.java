package com.ecommerce.pharmacy.service;

import com.ecommerce.pharmacy.Entity.Category;
import com.ecommerce.pharmacy.Entity.SubCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Category findCategoryById(Long id);
    List<SubCategory> findSubCategoriesByCategoryId(Long id);
    public Page<Category> findCategoriesWithPagination(int offset);
    public Page<Category> findCategoriesWithPaginationAndSorting(int offset,String field);

     void createCategory(Category category);

    void addSubCategory(Long categoryID, SubCategory subCategory);

    public Category updateCategory (Long id, Category category)throws Exception;
    public void deleteCategoryById(Long id)throws Exception;
}

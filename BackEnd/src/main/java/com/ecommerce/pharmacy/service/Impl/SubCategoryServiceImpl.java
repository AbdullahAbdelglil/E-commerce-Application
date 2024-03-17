package com.ecommerce.pharmacy.service.Impl;

import com.ecommerce.pharmacy.DAO.SubCategoryRepository;
import com.ecommerce.pharmacy.Entity.Category;
import com.ecommerce.pharmacy.Entity.Product;
import com.ecommerce.pharmacy.Entity.SubCategory;
import com.ecommerce.pharmacy.service.CategoryService;
import com.ecommerce.pharmacy.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;
    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository, CategoryService categoryService) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryService = categoryService;
    }


    @Override
    public SubCategory addSubCategory(Long categoryId, SubCategory subCategory) {
        Category category = categoryService.findCategoryById(categoryId);
        subCategory.setCategory(category);
        subCategoryRepository.save(subCategory);

        return subCategory;
    }

    @Override
    public void addProducts(Long subCategoryId, List<Product> productList) {
        SubCategory dbSubCategory = getSubCategory(subCategoryId);
        for(Product product:productList) {
            String name = product.getName();
            name=name.trim();
            product.setName(name);
            
            if(product.getPriceAfterDiscount()==0) {
                product.setPriceAfterDiscount(product.getPrice());
            }
            dbSubCategory.addProduct(product);
        }
        subCategoryRepository.save(dbSubCategory);
    }

    @Override
    public SubCategory getSubCategory(Long id) {
        return subCategoryRepository.getSubCategoryById(id);
    }

    @Override
    public SubCategory getSubCategory(String title) {
        return subCategoryRepository.getSubCategoryByTitle(title);
    }

    @Override
    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }
}

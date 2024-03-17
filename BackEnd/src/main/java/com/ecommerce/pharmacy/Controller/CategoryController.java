package com.ecommerce.pharmacy.Controller;

import com.ecommerce.pharmacy.Entity.Category;
import com.ecommerce.pharmacy.Entity.SubCategory;
import com.ecommerce.pharmacy.service.CategoryService;
import com.ecommerce.pharmacy.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public Category getCategoryById (@RequestParam("id") Long id) {
        return categoryService.findCategoryById(id);
    }

    @GetMapping("/{id}/sub-categories")
    public List<SubCategory> getSubCategoriesByCategoryId (@PathVariable("id") Long categoryId) {
        return categoryService.findSubCategoriesByCategoryId(categoryId);
    }

    @PostMapping("/secure/create")
    public String createCategory(@RequestBody Category category ){
        categoryService.createCategory(category);
        return "Success";
    }

    @PostMapping("/secure/{categoryID}/sub-category")
    public void addNewSubCategoryList(@PathVariable("categoryID") Long categoryID
                                        ,@RequestBody SubCategory subCategory) {

        categoryService.addSubCategory(categoryID, subCategory);
    }

    @PutMapping("/secure/update")
    public Category updateCategory (@RequestParam("category_id") Long id,
                                    @RequestBody Category category,
                                    @RequestHeader(value = "Authorization") String token) throws Exception{
        String admin = ExtractJWT.payloadJWTExtraction(token,"\"userType\"");
        if (admin != null && admin.equals("0oaay7q4bqrtzxXOk5d7")) {
            admin = "admin";
        }
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administrator only");
        }
        return categoryService.updateCategory(id,category);
    }

    @DeleteMapping("/secure/delete")
    public void removeCategory (@RequestParam("category_id") Long id,
                                @RequestHeader(value = "Authorization") String token) throws Exception{
        String admin = ExtractJWT.payloadJWTExtraction(token,"\"userType\"");
        if (admin != null && admin.equals("0oaay7q4bqrtzxXOk5d7")) {
            admin = "admin";
        }
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administrator only");
        }
        categoryService.deleteCategoryById(id);
    }
}

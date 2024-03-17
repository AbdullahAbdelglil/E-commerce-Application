package com.ecommerce.pharmacy.Controller;

import com.ecommerce.pharmacy.Entity.Product;
import com.ecommerce.pharmacy.Entity.SubCategory;
import com.ecommerce.pharmacy.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sub-category")
public class SubCategoryController {
    private SubCategoryService subCategoryService;

    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

//    @PostMapping("/category/{categoryID}")
//    public SubCategory addSubCategory(@PathVariable("categoryID") Long id,
//                                      @RequestBody SubCategory subCategory) {
//        return subCategoryService.addSubCategory(id, subCategory);
//    }

    @PutMapping("/{subCategoryID}/products")
    public void addProducts(@PathVariable("subCategoryID") Long subCategoryID,
                            @RequestBody List<Product> products) {
        subCategoryService.addProducts(subCategoryID, products);
    }

    @GetMapping("/{id}/products")
    public List<Product> getProductListOfSubCategory(@PathVariable("id")Long subCategoryId) {
        SubCategory dbSubCategory = subCategoryService.getSubCategory(subCategoryId);
        if(dbSubCategory != null) return dbSubCategory.getProducts();
        return null;
    }
}

package com.ecommerce.pharmacy.service;


import com.ecommerce.pharmacy.DTO.ProductDTO;
import com.ecommerce.pharmacy.Entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product findProductById(Long Id) throws Exception;

    Product findProductByName(String name);

    List<Product> findProductsByNameContains(String subStr);

    List<Product> findProductsByNameStartingWith(String prefix);

    List<Product> getProductsBySubCategoryId(Long categoryId) throws Exception;

    List<Product> getProductsBySubCategoryTitle(String title);

    public Page<Product> findProductsWithPaginationAndSorting(int offset, String field);

    public void postProduct(ProductDTO productDTO);

    public Product updateProduct(Long id, Product product) throws Exception;

    public void deleteProductById(Long id) throws Exception;

}

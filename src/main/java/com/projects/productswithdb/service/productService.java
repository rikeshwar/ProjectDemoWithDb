package com.projects.productswithdb.service;

import com.projects.productswithdb.Model.Product;

import java.util.List;
import java.util.Optional;

public interface productService {
    //product createProduct(productPostRequestDto productPostRequestDto);
    Product createProduct(Product product);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String CategoryName);
    Product getProductById(long id);
    void deleteProductById(long id);
    Product updateProduct(Product product);
    Product updateSpecificField(Product product);
}

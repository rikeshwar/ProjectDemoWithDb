package com.projects.productswithdb.controller;


import com.projects.productswithdb.Model.Product;
import com.projects.productswithdb.exception.CategoryNotFoundException;
import com.projects.productswithdb.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class ProductController {
    @Autowired
    productService productService;

    @GetMapping("/products")
    List<Product> getAllProducts()
    {
        return productService.getAllProducts();

    }
    @GetMapping("/products/id/{id}")
    Product getProductById(@PathVariable long id)
    {
        return productService.getProductById(id);
    }
    @GetMapping("/productsByCategory")
    public List<Product> getProductByCategory(@RequestParam("catName") String catName) throws CategoryNotFoundException
    {
        return productService.getProductsByCategory(catName);
    }



    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);

    }
    @RequestMapping(method = RequestMethod.PUT,path = "/products")
    public Product updateProduct(@RequestBody  Product product)
    {
        return productService.updateProduct(product);


    }
    @RequestMapping(method =RequestMethod.PATCH,path="/products")
    public Product updateSpecificField(@RequestBody Product product)
    {
        return productService.updateSpecificField(product);

    }
    //comment


    @DeleteMapping("/products/id/{id}")
    public String deleteProduct(@PathVariable long id)
    {
        //return productService.deleteProductById(id);
        productService.deleteProductById(id);
        return "deleted";
    }


}

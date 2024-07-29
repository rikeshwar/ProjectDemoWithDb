package com.projects.productswithdb.service;

import com.projects.productswithdb.Model.Category;
import com.projects.productswithdb.Model.Product;
import com.projects.productswithdb.exception.CategoryNotFoundException;
import com.projects.productswithdb.exception.ProductNotFoundException;
import com.projects.productswithdb.repository.categoryRepository;
import com.projects.productswithdb.repository.productRepository;
//import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.*;


@Service
public class RealProductService implements productService{

    @Autowired
    productRepository productRepository;
    @Autowired
    categoryRepository categoryRepository;


    @Override
    public Product createProduct(Product product) {

//        if(categoryRepository.findByName(product.getCategory().getName())==null)
//            categoryRepository.save(product.getCategory());
//        return productRepository.save(product);
        Optional<Category> category = categoryRepository.findByName(product.getCategory().getName());
//        if (category == null) {
//            category = new Category();
//            category.setName(product.getCategory().getName());
//            categoryRepository.save(category);
//        }
        if(category.isEmpty())
            product.setCategory(categoryRepository.save(new Category(product.getCategory().getName())));
        else product.setCategory(category.get());
        return productRepository.save(product);




    }
    //optional is just a container will either be empty or keep a objetc
    //of non null type.....but if u want you can keep null too by specifying
    //nullable
    @Override
    public Product getProductById (long id) throws ProductNotFoundException
    {
        //return productRepository.findProductById(id);
        Optional<Product> productOptional= productRepository.findProductById(id);
        if(productOptional.isEmpty())
            throw new ProductNotFoundException("product with id "+ id+" doesn't exit");
        return productOptional.get();

    }

    @Override
    public List<Product> getAllProducts() {
        //return productRepository.getEveryProduct();
        return productRepository.findAll();

    }
    @Override
    public void deleteProductById(long id)
    {

        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Product product) throws ProductNotFoundException {
        Optional<Product> productOptional=productRepository.getProductsById(product.getId());
        if(productOptional.isEmpty())
            throw new ProductNotFoundException("there is no product to update with id " +
                    product.getId()+" if u wish to create new product call post Request");
        Optional<Category> category = categoryRepository.findByName(product.getCategory().getName());
//        if (category == null) {
//            category = new Category();
//            category.setName(product.getCategory().getName());
//            categoryRepository.save(category);
//        }
        Category newCategory=null;
        if(category.isEmpty()) {
            newCategory = new Category(product.getCategory().getName());
            newCategory=categoryRepository.save(newCategory);

        }
        product.setCategory(newCategory);
        //here line 78 to 81 code required because what if you update the
        //category which is a class type data and need to handled seperately
        //there is two either you tell the jpa to handle it by "CASCADING"
        //or you handle it by yourself....!!here we did ourself

        Product updatedProduct= productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public Product updateSpecificField(Product product) throws ProductNotFoundException {
        Optional<Product> productFromDb=productRepository.getProductsById(product.getId());
        if(productFromDb.isEmpty())throw new ProductNotFoundException("there is no such product to update");
        if(product.getCategory()!=null)
        {
            Optional<Category> categoryFromDb;
            //if(product.getCategory().getName()!=null)
            categoryFromDb=categoryRepository.findByName(product.getCategory().getName());
            //if(product.getCategory().getId()!=null)
            //    categoryFromDb=categoryRepository.findById(product.getCategory().getId());
            if(categoryFromDb.isEmpty())
                productFromDb.get().setCategory(categoryRepository.save(product.getCategory()));



        }
        if(product.getName()!=null)productFromDb.get().setName(product.getName());
        if(product.getDescription()!=null)productFromDb.get().setDescription(product.getDescription());
        //if(product.getPrice()!=null)productFromDb.setPrice(product.getPrice());
        //in model doule used of primitive datatype hence here null is not working
        if(product.getPrice()!=null)productFromDb.get().setPrice(product.getPrice());

        return productRepository.save(productFromDb.get());

    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) throws CategoryNotFoundException{
        //return productRepository.getProductsByCategoryName(categoryName);
        List<Product> products=  productRepository.getproductwithgivenCategoryBySql(categoryName);
        if(products.isEmpty())throw new CategoryNotFoundException("there is no category with name "+categoryName);
        return products;
        //return null;
    }
}

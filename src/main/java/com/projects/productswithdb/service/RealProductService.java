package com.projects.productswithdb.service;

import com.projects.productswithdb.Model.Category;
import com.projects.productswithdb.Model.Product;
import com.projects.productswithdb.repository.categoryRepository;
import com.projects.productswithdb.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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
        Category category = categoryRepository.findByName(product.getCategory().getName());
        if (category == null) {
            category = new Category();
            category.setName(product.getCategory().getName());
            categoryRepository.save(category);
        }
        product.setCategory(category);
        return productRepository.save(product);




    }
    @Override
    public Product getProductById(long id)
    {
        //return productRepository.findProductById(id);
        return productRepository.getProductsById(id);
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
    public Product updateProduct(Product product) {
        Category category = categoryRepository.findByName(product.getCategory().getName());
        if (category == null) {
            category = new Category();
            category.setName(product.getCategory().getName());
            categoryRepository.save(category);
        }
        product.setCategory(category);
        //here line 63 to 69 code required because what if you update the
        //category which is a class type data and need to handled seperately
        //there is two either you tell the jpa to handle it by "CASCADING"
        //or you handle it by yourself....!!here we did ourself

        Product updatedProduct= productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public Product updateSpecificField(Product product) {
        Product productFromDb=productRepository.getProductsById(product.getId());
        if(product.getCategory()!=null)
        {
            Category category=categoryRepository.findByName(product.getCategory().getName());
            if(category==null) {
                category = new Category(product.getCategory().getName());
                categoryRepository.save(category);
            }
            productFromDb.setCategory(category);

        }
        if(product.getName()!=null)productFromDb.setName(product.getName());
        if(product.getDescription()!=null)productFromDb.setDescription(product.getDescription());
        //if(product.getPrice()!=null)productFromDb.setPrice(product.getPrice());
        //in model doule used of primitive datatype hence here null is not working
        if(product.getPrice()!=null)productFromDb.setPrice(product.getPrice());

        return productRepository.save(productFromDb);

    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        //return productRepository.getProductsByCategoryName(categoryName);
        return  productRepository.getproductwithgivenCategoryBySql(categoryName);
        //return null;
    }
}

package com.projects.productswithdb.repository;

import com.projects.productswithdb.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface productRepository extends JpaRepository<Product,Long> {
    Product save(Product product);//this save work both for the insert and
    //the update if product has the id then will do update else will insert
    //jpa will take care of the checking the id


    @Query(value="select * from product p",nativeQuery = true)
    List<Product> getEveryProduct();

    List<Product> findAll();

    //Product updateById(long id);





    Optional<Product> findProductById(long id);
    Optional<Product> getProductsById(long id);


    //Product deleteProductById(long id);



    List<Product> getProductsByCategoryName(String categoryName);

    @Query("select p from Product p where p.category.name= :categoryName order by p.name")
    List<Product> getproductwithgivenCategoryByHql(@Param("categoryName") String catName);
               //@Param here the map catNmae to categoryNmae and same exact
      //"categoryName" should ne used in Hql after where clause

    @Query(value = "select p.* from Product p left join category c on p.category_id=c.id where c.name= :categoryName order by p.name",nativeQuery = true)
    List<Product> getproductwithgivenCategoryBySql(@Param("categoryName") String catName);

    @Query(value="select * from product p",nativeQuery = true)
    List<ProductProjection> getProductUsingProjectionBySql();

    @Query(value="select p.name as nameee ,p.id as iddd from Product p")
    List<ProductProjection> getProductUsingProjectionByHql();

}

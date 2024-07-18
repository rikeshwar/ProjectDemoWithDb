package com.projects.productswithdb;

import com.projects.productswithdb.Model.Product;
import com.projects.productswithdb.repository.ProductProjection;
import com.projects.productswithdb.repository.productRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductsWithDbApplicationTests {
	productRepository productRepository;

	@Autowired
	public ProductsWithDbApplicationTests(productRepository productRepository)
	{
		this.productRepository=productRepository;
	}

	@Test
	void contextLoads() {
	}
//	@Test
//	void TestProductByCategoryBySql()
//	{
//		List<Product> productList=productRepository.getproductwithgivenCategoryBySql("mobile");
//		productList.forEach((Product product)-> System.out.println(product.getName()+" "+product.getCategory().getName()) );
////		for(Product product:productList)
////		{
////			System.out.println(product.getName()+" "+product.getCategory().getName());
////		}
//	}
//	@Test
//	void TestProductProjectionByHql()
//	{
//		List<ProductProjection> productProjections=productRepository.getProductUsingProjectionByHql();
//		productProjections.forEach((ProductProjection p )-> System.out.println(p.getIddd()+" "+p.getNameee()));
//	}

}

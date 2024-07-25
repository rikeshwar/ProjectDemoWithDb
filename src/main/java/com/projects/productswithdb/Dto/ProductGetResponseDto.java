package com.projects.productswithdb.Dto;

import com.projects.productswithdb.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class ProductGetResponseDto {
    //private Product product;
    private List<Product> products;
    private String status;


}

package com.projects.productswithdb.Dto;

import com.projects.productswithdb.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductPostResponseDto {
    private Product product;
    private String status;
}

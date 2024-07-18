package com.projects.productswithdb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor

@NoArgsConstructor
@Entity

public class Category extends BaseModel{
    private String name;
//    @OneToMany (mappedBy ="category")
//    private List<Product> productList;
}

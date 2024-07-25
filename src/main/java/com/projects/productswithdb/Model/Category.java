package com.projects.productswithdb.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

  @OneToMany (mappedBy ="category",fetch = FetchType.LAZY)
  @JsonIgnore
  private List<Product> productList;

  public Category(String name)
  {
      this.name=name;
  }
}

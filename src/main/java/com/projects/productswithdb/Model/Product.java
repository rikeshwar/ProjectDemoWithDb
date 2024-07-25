package com.projects.productswithdb.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="product_table")
@SQLDelete(sql="UPDATE product SET is_Deleted=true where id=?")
@Where(clause="is_Deleted=false")//carefull....this won't work if you write your
//custom query....select * from product) so will fetch all the product even
//row with isDeleted=true....!!..so need to update custom query
//select * from product where is_Deleted=false
//where as if jpa is writting any crud query it will always include where
//clause ....."where is_Deleted=false",so other query perform consistently
//and will only applicable on row which is not deleted
public class Product extends BaseModel {
    private String name;
    private Double price;//Double is better over double as Double is classType
    //could used to compare with null for some validation
    private  String description;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

}

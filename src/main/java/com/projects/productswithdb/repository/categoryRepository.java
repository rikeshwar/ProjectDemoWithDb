package com.projects.productswithdb.repository;

import com.projects.productswithdb.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<Category,Long> {

    Category save(Category category);

    Category findByName(String name);

}

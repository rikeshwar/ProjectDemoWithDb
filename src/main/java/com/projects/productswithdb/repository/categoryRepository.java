package com.projects.productswithdb.repository;

import com.projects.productswithdb.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface categoryRepository extends JpaRepository<Category,Long> {

    Category save(Category category);

    Optional<Category> findByName(String name);
    Optional<Category> findById(Long id);

}

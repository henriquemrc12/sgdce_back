package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.CategoryModel;
import com.nowsystems.sgdce.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    @Query(value = "FROM CategoryModel c where c.id IN (:ids)")
    List<CategoryModel> findAllByIds(List<Long> ids);
}

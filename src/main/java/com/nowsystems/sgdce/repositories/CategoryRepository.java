package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.CategoryModel;
import com.nowsystems.sgdce.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}

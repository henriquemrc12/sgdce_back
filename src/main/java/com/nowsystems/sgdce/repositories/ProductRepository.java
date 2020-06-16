package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    ProductModel findProductModelByName(String name);

    ProductModel findProductModelByBarCode(String name);
}

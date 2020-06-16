package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

}

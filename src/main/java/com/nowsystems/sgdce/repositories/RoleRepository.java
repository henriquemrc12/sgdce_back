package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    @Query(value = "FROM RoleModel r WHERE r.id IN( :ids)")
    List<RoleModel> findAllByIds(List<Long> ids);
}

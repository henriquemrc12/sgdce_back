package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SaleRepository extends JpaRepository<SaleModel, Long> {

    SaleModel findSaleModelBySaleNumber(String number);

    List<SaleModel> findAllByDateSale(Date date);
}

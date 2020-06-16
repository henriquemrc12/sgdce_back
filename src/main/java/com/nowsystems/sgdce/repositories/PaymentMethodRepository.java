package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodModel, Long> {
}

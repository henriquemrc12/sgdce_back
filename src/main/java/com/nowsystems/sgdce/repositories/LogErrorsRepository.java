package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.logErrorsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogErrorsRepository extends JpaRepository<logErrorsModel, Long> {
}

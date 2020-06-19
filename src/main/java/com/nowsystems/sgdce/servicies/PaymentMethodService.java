package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodService {

    @Autowired
    private PaymentMethodRepository repo;

    public List<PaymentMethodModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public PaymentMethodModel findById(Long id) {
        try {
            Optional<PaymentMethodModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public PaymentMethodModel create(PaymentMethodModel paymentMethodModel) {
        try {
            PaymentMethodModel p = new PaymentMethodModel();

            p.setId(null);
            p.setName(paymentMethodModel.getName());
            p.setActive(true);
            return repo.save(p);
        } catch (Exception e) {
            throw new ApiException("Não foi possível cadastrar o método de pagamento.");
        }


    }
}

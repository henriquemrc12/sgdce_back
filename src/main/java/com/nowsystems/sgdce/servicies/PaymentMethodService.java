package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.models.logErrorsModel;
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

    @Autowired
    private LogErrorsService logErrorsService;

    public List<PaymentMethodModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("PaymentMethod");
            log.setMethodName("findAll");
            logErrorsService.create(log);
            return null;
        }
    }

    public PaymentMethodModel findById(Long id) {
        try {
            Optional<PaymentMethodModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("PaymentMethod");
            log.setMethodName("findById");
            logErrorsService.create(log);
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

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("PaymentMethod");
            log.setMethodName("create");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível cadastrar o método de pagamento.");
        }
    }

    @Transactional
    public PaymentMethodModel update(PaymentMethodModel paymentMethodModel) {
        try {

            PaymentMethodModel p = findById(paymentMethodModel.getId());
            if(paymentMethodModel.getActive()!=null) p.setActive(paymentMethodModel.getActive());
            if(paymentMethodModel.getName()!=null) p.setName(paymentMethodModel.getName());
            return repo.save(p);

        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("PaymentMethod");
            log.setMethodName("create");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível cadastrar o método de pagamento.");
        }
    }

    @Transactional
    public Boolean delete(Long id) {
        try {
            PaymentMethodModel p = findById(id);
            repo.delete(p);
            return true;
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("PaymentMethod");
            log.setMethodName("create");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível cadastrar o método de pagamento.");
        }
    }


}

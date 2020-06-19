package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.SaleModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.SaleModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repo;

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentMethodService paymentMethodService;

    public List<SaleModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public SaleModel findById(Long id) {
        try {
            Optional<SaleModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public SaleModel create(SaleModelDTO dto){
        try{
            SaleModel saleModel = new SaleModel();
            PaymentMethodModel paymentMethodModel = paymentMethodService.findById(dto.getPaymentMethodModel());
            saleModel.setId(null);
            saleModel.setDateSale(new Date());

            boolean n = false;
            while ( n ==false){
                int random = (int)(Math.random() * 100000+1000);
                SaleModel s = repo.findSaleModelBySaleNumber(random);
                if(s!=null){
                    n = false;
                }else{
                    saleModel.setSaleNumber(random);
                    n = true;
                }
            }

            saleModel.setPaymentMethodModel(paymentMethodModel);
            UserModel userModel = userService.findById(dto.getUser());
            saleModel.setUser(userModel);
            saleModel.setTotalValue(dto.getTotalValue());
            return repo.save(saleModel);
        }catch (ApiException e){
            throw e;
        }catch (Exception e){

            throw new ApiException("Não foi possível cadastrar a venda. Contate o suporte do sistema.");
        }
    }

}

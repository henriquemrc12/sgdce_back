package com.nowsystems.sgdce.dto;

import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class SaleModelDTO {

    private Long id;

    private Long user;

    private Long paymentMethodModel;

    private List<Long> products;

    private Double totalValue;

    public SaleModelDTO(Long id, Long user, Long paymentMethodModel, List<Long> products, Double totalValue) {
        this.id = id;
        this.user = user;
        this.paymentMethodModel = paymentMethodModel;
        this.products = products;
        this.totalValue = totalValue;
    }
    public SaleModelDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getPaymentMethodModel() {
        return paymentMethodModel;
    }

    public void setPaymentMethodModel(Long paymentMethodModel) {
        this.paymentMethodModel = paymentMethodModel;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}

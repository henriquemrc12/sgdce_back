package com.nowsystems.sgdce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sale")
public class SaleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    @ManyToOne()
    @JoinColumn(name = "payment_method_id", referencedColumnName = "id")
    private PaymentMethodModel paymentMethodModel;

    @ManyToMany
    @JoinTable(name = "sale_has_product", joinColumns = {
            @JoinColumn(name = "sale_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")})
    private List<ProductModel> products = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_sale")
    private Date dateSale;

    @Column(name = "sale_number")
    private Integer saleNumber;

    @Column(name = "total_value")
    private Double totalValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public PaymentMethodModel getPaymentMethodModel() {
        return paymentMethodModel;
    }

    public void setPaymentMethodModel(PaymentMethodModel paymentMethodModel) {
        this.paymentMethodModel = paymentMethodModel;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public Integer getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(Integer saleNumber) {
        this.saleNumber = saleNumber;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}

package com.nowsystems.sgdce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "payment_method")
public class PaymentMethodModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String name;

    private Boolean active;

    @JsonBackReference("user_sales")
    @OneToMany(mappedBy = "paymentMethodModel")
    private List<SaleModel> sale = new ArrayList<>();

    public PaymentMethodModel(Long id, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String name, Boolean active, List<SaleModel> sale) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.sale = sale;
    }

    public PaymentMethodModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<SaleModel> getSale() {
        return sale;
    }

    public void setSale(List<SaleModel> sale) {
        this.sale = sale;
    }
}

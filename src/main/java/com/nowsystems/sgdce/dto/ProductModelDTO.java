package com.nowsystems.sgdce.dto;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class ProductModelDTO {

    private Long id;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String name;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String barCode;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String description;

    private Integer amount;

    private Double purchasePrice;

    private Double salePrice;

    private Date purchaseDate;

    private List<Long> categories;

    public ProductModelDTO(Long id, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String name, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String barCode, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String description, Integer amount, Double purchasePrice, Double salePrice, Date purchaseDate) {
        this.id = id;
        this.name = name;
        this.barCode = barCode;
        this.description = description;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.purchaseDate = purchaseDate;
    }

    public ProductModelDTO() {}

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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }
}

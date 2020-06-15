package com.nowsystems.sgdce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "product")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String name;

    @Column(name = "bar_code")
    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String barCode;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String description;

    private Integer amount;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "sale_price")
    private Double salePrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "purchase_date")
    @CreatedDate
    private Date purchaseDate;

    @ManyToMany
    @JoinTable(name = "product_has_category", joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<CategoryModel> categories = new ArrayList<>();


    @JsonBackReference("user_sales_reference")
    @ManyToMany(mappedBy = "products")
    private List<SaleModel> sales = new ArrayList<>();

    public ProductModel(Long id, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String name, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String barCode, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String description, Integer amount, Double purchasePrice, Double salePrice, Date purchaseDate, List<CategoryModel> categories, List<SaleModel> sales) {
        this.id = id;
        this.name = name;
        this.barCode = barCode;
        this.description = description;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.purchaseDate = purchaseDate;
        this.categories = categories;
        this.sales = sales;
    }

    public ProductModel() {}

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

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public List<SaleModel> getSales() {
        return sales;
    }

    public void setSales(List<SaleModel> sales) {
        this.sales = sales;
    }
}

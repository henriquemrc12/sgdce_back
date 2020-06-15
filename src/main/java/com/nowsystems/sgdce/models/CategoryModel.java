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
@Table(name = "category")
public class CategoryModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String name;

    @JsonBackReference("user_role_reference")
    @ManyToMany(mappedBy = "categories")
    private List<ProductModel> products = new ArrayList<>();

    public CategoryModel(Long id, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String name, List<ProductModel> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public CategoryModel(){}

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

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}

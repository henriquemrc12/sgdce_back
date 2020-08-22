package com.nowsystems.sgdce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "cashier")
public class CashierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isOpen;

    private Boolean isDisabled;

    @ManyToMany
    @JoinTable(name = "cashier_has_users", joinColumns = {
            @JoinColumn(name = "cashier_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")})
    private List<UserModel> allowedUsers;


    public CashierModel(Long id, String name, Boolean isOpen, Boolean isDisabled, List<UserModel> allowedUsers) {
        this.id = id;
        this.name = name;
        this.isOpen = isOpen;
        this.isDisabled = isDisabled;
        this.allowedUsers = allowedUsers;
    }

    public CashierModel(){}

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

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    public List<UserModel> getAllowedUsers() {
        return allowedUsers;
    }

    public void setAllowedUsers(List<UserModel> allowedUsers) {
        this.allowedUsers = allowedUsers;
    }
}

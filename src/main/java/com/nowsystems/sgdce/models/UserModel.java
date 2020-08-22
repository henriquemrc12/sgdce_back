package com.nowsystems.sgdce.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")
public class UserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String name;

    @Column(unique = true)
    @Size(max = 11, message = "O campo não pode ter mais que 11 caracteres.")
    private String cpf;

    @Basic(optional = false)
    @Column(unique = true)
    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String email;

    @Size(max = 255, message = "O campo não pode ter mais que 12 caracteres.")
    private String password;

    @Size(max = 12, message = "O campo não pode ter mais que 12 caracteres.")
    private String phone;

    private Boolean active;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @ManyToMany
    @JoinTable(name = "user_has_role", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<RoleModel> roles = new ArrayList<>();

    @JsonBackReference("user_sales")
    @OneToMany(mappedBy = "user")
    private List<SaleModel> sale = new ArrayList<>();

    @JsonBackReference("user_roles_reference")
    @ManyToMany(mappedBy = "allowedUsers")
    private List<CashierModel> cashier = new ArrayList<>();

    public UserModel(Long id,@Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String name, @Size(max = 11, message = "O campo não pode ter mais que 11 caracteres.") String cpf, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String email, @Size(max = 255, message = "O campo não pode ter mais que 12 caracteres.") String password, @Size(max = 12, message = "O campo não pode ter mais que 12 caracteres.") String phone, Boolean active, Date updatedAt, Date createdAt, List<RoleModel> roles) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.active = active;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.roles = roles;
    }



    public UserModel(){}

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleModel> roles) {
        this.roles = roles;
    }

    public List<SaleModel> getSale() {
        return sale;
    }

    public void setSale(List<SaleModel> sale) {
        this.sale = sale;
    }

    public List<CashierModel> getCashier() {
        return cashier;
    }

    public void setCashier(List<CashierModel> cashier) {
        this.cashier = cashier;
    }
}

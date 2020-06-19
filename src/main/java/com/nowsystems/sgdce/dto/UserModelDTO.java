package com.nowsystems.sgdce.dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.List;

public class UserModelDTO {

    private Long id;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String name;

    @Size(max = 11, message = "O campo não pode ter mais que 11 caracteres.")
    private String cpf;

    @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.")
    private String email;

    @Size(max = 255, message = "O campo não pode ter mais que 12 caracteres.")
    private String password;

    @Size(max = 12, message = "O campo não pode ter mais que 12 caracteres.")
    private String phone;

    private List<Long> roles;

    private Boolean active;

    public UserModelDTO(@Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String name, @Size(max = 11, message = "O campo não pode ter mais que 11 caracteres.") String cpf, @Size(max = 255, message = "O campo não pode ter mais que 255 caracteres.") String email, @Size(max = 255, message = "O campo não pode ter mais que 12 caracteres.") String password, @Size(max = 12, message = "O campo não pode ter mais que 12 caracteres.") String phone, List<Long> roles) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roles = roles;
    }

    public UserModelDTO() {}

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

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}

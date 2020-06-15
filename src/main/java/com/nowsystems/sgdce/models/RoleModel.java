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
@Table(name = "role")
public class RoleModel  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres.")
    private String name;

    @JsonBackReference("user_roles_reference")
    @ManyToMany(mappedBy = "roles")
    private List<UserModel> users = new ArrayList<>();

    public RoleModel(Long id, @Size(max = 100, message = "O campo não pode ter mais que 100 caracteres.") String name, List<UserModel> users) {
        this.id = id;
        this.name = name;
        this.users = users;
    }

    public RoleModel(){}

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

    public List<UserModel> getUsers() {
        return users;
    }

    public void setUsers(List<UserModel> users) {
        this.users = users;
    }
}

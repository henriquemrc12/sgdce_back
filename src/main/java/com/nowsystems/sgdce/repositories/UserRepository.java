package com.nowsystems.sgdce.repositories;

import com.nowsystems.sgdce.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findUserModelByEmail(String email);

    UserModel findUserModelByCpf(String cpf);

}

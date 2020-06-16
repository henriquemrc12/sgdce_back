package com.nowsystems.sgdce.servicies;

import com.amazonaws.services.identitymanagement.model.User;
import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.models.RoleModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.repositories.RoleRepository;
import com.nowsystems.sgdce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository roleRepository;

    public List<UserModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public UserModel findById(Long id) {
        try {
            Optional<UserModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public UserModel create(UserModelDTO dto) {
        try {
            List<RoleModel> roles = roleRepository.findAllByIds(dto.getRoles());

            UserModel userModel = new UserModel(null,dto.getName(),dto.getCpf(),dto.getEmail(),dto.getPassword(),dto.getPhone(),true,new Date(), new Date(),roles);

            return repo.save(userModel);
        }catch (Exception e){
            throw e;
        }
    }
}

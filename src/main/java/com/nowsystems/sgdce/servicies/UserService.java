package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.RoleModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.models.logErrorsModel;
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


    @Autowired
    private LogErrorsService logErrorsService;

    public List<UserModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("User");
            log.setMethodName("findAll");
            logErrorsService.create(log);
            return null;
        }
    }

    public UserModel findById(Long id) {
        try {
            Optional<UserModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("User");
            log.setMethodName("findById");
            logErrorsService.create(log);
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

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("User");
            log.setMethodName("create");
            logErrorsService.create(log);
            throw e;
        }
    }

    @Transactional
    public UserModel update(UserModelDTO dto){
        try{

            UserModel userModel = findById(dto.getId());

            if(userModel == null) throw new ApiException("Não foi possível encontrar Usuário com ID informado " + dto.getId());

            if(dto.getName() != null) userModel.setName(dto.getName());
            if(dto.getCpf() != null) userModel.setCpf(dto.getCpf());
            if(dto.getEmail() != null) userModel.setEmail(dto.getEmail());
            if(dto.getPassword() != null) userModel.setPassword(dto.getPassword());
            if(dto.getPhone() != null) userModel.setPhone(dto.getPhone());
            if(dto.getRoles()!=null){
                List<RoleModel> roles = roleRepository.findAllByIds(dto.getRoles());
                userModel.setRoles(roles);
            }
            if(dto.getActive()!= null) userModel.setActive(dto.getActive());
            userModel.setUpdatedAt(new Date());
            return repo.save(userModel);
        }catch (ApiException e){
            throw e;
        }catch (Exception e){

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("User");
            log.setMethodName("update");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível atualizar o Usuário.");
        }
    }

    public boolean turnActive(Long id){
        try{
            UserModel userModel = findById(id);
            userModel.setActive(userModel.getActive()?false:true);
            repo.save(userModel);
            return true;
        }catch (Exception e){
            UserModel userModel = findById(id);
            String active = userModel.getActive()?"Desativar":"Ativar";

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("User");
            log.setMethodName("turnActive");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível "+ active + " o Usuário.");
        }
    }
}

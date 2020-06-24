package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.ProductModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.RoleModel;
import com.nowsystems.sgdce.models.logErrorsModel;
import com.nowsystems.sgdce.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository repo;

    @Autowired
    private LogErrorsService logErrorsService;

    public List<RoleModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("Role");
            log.setMethodName("findAll");
            logErrorsService.create(log);
            return null;

        }
    }

    public RoleModel findById(Long id) {
        try {
            Optional<RoleModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("Role");
            log.setMethodName("findById");
            logErrorsService.create(log);
            return null;
        }
    }

    @Transactional
    public RoleModel create(RoleModel roleModel) {
        try {
            RoleModel r = new RoleModel();
            r.setId(null);
            r.setName(roleModel.getName());
            return repo.save(r);
        }catch (Exception e){

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("Role");
            log.setMethodName("create");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível cadastrar o Nível de Usuário.");
        }
    }
}

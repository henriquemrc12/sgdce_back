package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.CategoryModel;
import com.nowsystems.sgdce.models.logErrorsModel;
import com.nowsystems.sgdce.repositories.LogErrorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogErrorsService {

    @Autowired
    private LogErrorsRepository repo;

    public List<logErrorsModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {

            return null;
        }
    }

    public logErrorsModel findById(Long id) {
        try {
            Optional<logErrorsModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public logErrorsModel create(logErrorsModel log){
        try{
            log.setId(null);
            log.setActive(true);
            log.setDate(new Date());
            return repo.save(log);
        }catch (ApiException e){
            throw e;
        }catch (Exception e){
            throw new ApiException("Não foi possivel cadastar log");
        }
    }

    public Boolean setActive(Long id){
        try{
            logErrorsModel l = findById(id);
            l.setActive(l.getActive()?false:true);
            repo.save(l);
            return true;
        }catch (Exception e){
            throw e;
        }
    }

}

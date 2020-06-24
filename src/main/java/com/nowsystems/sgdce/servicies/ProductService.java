package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.ProductModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.CategoryModel;
import com.nowsystems.sgdce.models.ProductModel;
import com.nowsystems.sgdce.models.logErrorsModel;
import com.nowsystems.sgdce.repositories.CategoryRepository;
import com.nowsystems.sgdce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private LogErrorsService logErrorsService;

    public List<ProductModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("Products");
            log.setMethodName("findAll");
            logErrorsService.create(log);
            return null;
        }
    }

    public ProductModel findById(Long id) {
        try {
            Optional<ProductModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("Products");
            log.setMethodName("findById");
            logErrorsService.create(log);
            return null;
        }
    }

    @Transactional
    public ProductModel create(ProductModelDTO dto) {
        try {
            ProductModel productModel = new ProductModel();
            productModel.setId(null);
            productModel.setName(dto.getName());
            productModel.setDescription(dto.getDescription());
            productModel.setAmount(dto.getAmount());
            productModel.setBarCode(dto.getBarCode());
            List<CategoryModel> categories = categoryRepository.findAllByIds(dto.getCategories());
            productModel.setCategories(categories);
            productModel.setPurchaseDate(dto.getPurchaseDate());
            productModel.setPurchasePrice(dto.getPurchasePrice());
            return repo.save(productModel);

        } catch (Exception e) {

            logErrorsModel log = new logErrorsModel();
            log.setCause(e.getCause().toString());
            log.setMessage(e.getMessage());
            log.setCompanyName("Default");
            log.setTableName("Products");
            log.setMethodName("create");
            logErrorsService.create(log);
            throw new ApiException("Não foi possível cadastrar o produto.");
        }
    }
}

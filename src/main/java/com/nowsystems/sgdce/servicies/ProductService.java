package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.ProductModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.CategoryModel;
import com.nowsystems.sgdce.models.ProductModel;
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

    public List<ProductModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public ProductModel findById(Long id) {
        try {
            Optional<ProductModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {
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
            throw new ApiException("Não foi possível cadastrar o produto.");
        }
    }
}

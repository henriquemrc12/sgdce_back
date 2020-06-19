package com.nowsystems.sgdce.servicies;

import com.nowsystems.sgdce.dto.SaleModelDTO;
import com.nowsystems.sgdce.exception.ApiException;
import com.nowsystems.sgdce.models.CategoryModel;
import com.nowsystems.sgdce.models.SaleModel;
import com.nowsystems.sgdce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public List<CategoryModel> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    public CategoryModel findById(Long id) {
        try {
            Optional<CategoryModel> obj = repo.findById(id);
            return obj.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    public CategoryModel create(CategoryModel categoryModel) {
        try {
            CategoryModel c = new CategoryModel();
            c.setId(null);
            c.setName(categoryModel.getName());
            return repo.save(c);
        } catch (Exception e) {
            throw new ApiException("Não foi possível criar uma categoria nova.");
        }
    }
}

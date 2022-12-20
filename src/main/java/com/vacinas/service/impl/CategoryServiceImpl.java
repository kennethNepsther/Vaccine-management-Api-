package com.vacinas.service.impl;

import com.vacinas.model.CategoryModel;
import com.vacinas.repository.CategoryRepository;
import com.vacinas.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    final CategoryRepository categoryRepository;

    @Override
    public CategoryModel findById(Long id) {
        Optional<CategoryModel> newObj = categoryRepository.findById(id);
        return newObj.orElse(null);    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryModel create(CategoryModel categoryModel) {
        categoryModel.setId(null);
        return categoryRepository.save(categoryModel);
    }

    @Override
    public CategoryModel update(Long id, CategoryModel categoryModel) {
        return null;
    }

    @Override
    public void delete(Long id) {
        findById(id);
        categoryRepository.deleteById(id);

    }
}

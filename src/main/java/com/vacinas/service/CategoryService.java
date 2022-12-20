package com.vacinas.service;

import com.vacinas.model.CategoryModel;

import java.util.List;

public interface CategoryService {

    CategoryModel findById(Long id);

    List<CategoryModel> findAll();

    CategoryModel create(CategoryModel categoryModel);

    CategoryModel update(Long id, CategoryModel categoryModel);

    void delete(Long id);
}

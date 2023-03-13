package com.arg.ecommerce.service;

import com.arg.ecommerce.domain.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> listCategories();

    public void save(Category category);

    public void delete(Category category);

    public Category findCategoryById(Category category);






}

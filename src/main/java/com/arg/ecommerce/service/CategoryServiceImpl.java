package com.arg.ecommerce.service;

import com.arg.ecommerce.dao.CategoryDao;
import com.arg.ecommerce.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDao categoryDao;


    @Transactional(readOnly = true)
    @Override
    public List<Category> listCategories() {
        return categoryDao.findAll();
    }

    @Transactional
    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Transactional
    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Transactional(readOnly = true)
    @Override
    public Category findCategoryById(Category category) {
        return categoryDao.findById(category.getId()).orElse(null);
    }
}

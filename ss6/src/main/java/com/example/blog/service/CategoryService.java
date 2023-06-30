package com.example.blog.service;

import com.example.blog.model.Category;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> displayCategoryList() {
        return categoryRepository.findAll();
    }

    @Override
    public void createNewCategory(Category category) {

    }

    @Override
    public void deleteCategory(int id) {

    }

    @Override
    public void editCategory(int id) {

    }

    @Override
    public Category getCategoryDetail(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}

package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;
    @GetMapping()
    public List<Category> getCategory(){
        return this.categoryService.displayCategoryList();
    }
    @GetMapping("/view/{id}")
    public Category getCategoryDetail(@PathVariable Integer id){
        return this.categoryService.getCategoryDetail(id);
    }
}

//package com.example.blog.controller;
//
//import com.example.blog.service.ICategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class CategoryController {
//    @Autowired
//    private ICategoryService categoryService;
//
//    @GetMapping("/category")
//    public String displayListCategory( Model model) {
//        model.addAttribute("categoryList",categoryService.displayCategoryList());
//        return "categorys";
//    }
//}

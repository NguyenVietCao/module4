package com.example.blog.service;

import com.example.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    //    Tạo danh mục mới
//    Xem danh sách danh mục
//    Xoá danh mục
//    Chỉnh sửa danh mục
    List<Category> displayCategoryList();

    void createNewCategory(Category category);

    void deleteCategory(int id);

    void editCategory(int id);

    Category getCategoryDetail(int id);
}

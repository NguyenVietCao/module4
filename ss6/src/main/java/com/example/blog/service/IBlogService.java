package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> displayListBlog(Pageable pageable);

    void addNewBlog(Blog blog);

    void editBlog(Blog blog);

    boolean deleteBlog(int id);
    Blog getBlogById(int id);

}

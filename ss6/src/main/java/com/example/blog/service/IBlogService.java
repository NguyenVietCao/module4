package com.example.blog.service;

import com.example.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> displayListBlog();

    void addNewBlog(Blog blog);

    void editBlog(Blog blog);

    boolean deleteBlog(int id);
    Blog getBlogById(int id);

}

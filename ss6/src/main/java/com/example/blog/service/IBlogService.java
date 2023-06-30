package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> displayListBlog(Pageable pageable);
    // web service

    List<Blog> getBlogs();

    Blog getBlogDetail(int id);

    void createBlog(Blog blog);

    void updateBlog(Blog blog);
    void delete(int id);
    List<Blog>searchBlogById(int id);
    // web service

    void addNewBlog(Blog blog);

    void editBlog(Blog blog);

    boolean deleteBlog(int id);

    Blog getBlogById(int id);

}

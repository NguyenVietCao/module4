package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> displayListBlog(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public void addNewBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void editBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public boolean deleteBlog(int id) {
        iBlogRepository.deleteById(id);
        return true;
    }

    @Override
    public Blog getBlogById(int id) {

        return iBlogRepository.findById(id).get();
    }
}

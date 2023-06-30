package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public List<Blog> getBlog() {
        return this.blogService.getBlogs();
    }

    @GetMapping("{id}")
    public Blog getBlogDetail(@PathVariable Integer id) {
        return this.blogService.getBlogDetail(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlog(@RequestBody Blog blog) {
        this.blogService.createBlog(blog);
    }

    @PutMapping()
    public void updateBlog(@RequestBody Blog blog) {
        this.blogService.updateBlog(blog);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        this.blogService.delete(id);
    }
    @GetMapping("/c/{id}")
    public List<Blog>searchCategoryByBlog(@PathVariable Integer id){
       return this.blogService.searchBlogById(id);

    }
}

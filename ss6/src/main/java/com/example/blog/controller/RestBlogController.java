package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/blog")
@CrossOrigin("*")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> display() {
        return new ResponseEntity<>(blogService.displayListBlog(), HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
//    @PostMapping("/search/{id}")
    public ResponseEntity <Blog> getBlogDetail(@PathVariable Integer id) {
        Blog blog = null;
        if (blogService.getBlogDetail(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blog = blogService.getBlogDetail(id);
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlog(@RequestBody Blog blog) {
        this.blogService.createBlog(blog);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Blog> delete(@PathVariable Integer id) {
        Blog blog = null;
        if (id == null) {
           return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            blogService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

//    @GetMapping("/c/{id}")
    @PostMapping("/search/{id}")
    public ResponseEntity <List<Blog>> searchCategoryByBlog(@PathVariable Integer id) {
        Blog blog = null;
        if (id == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            this.blogService.searchBlogById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }
}

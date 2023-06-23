package com.example.blog.controller;

import com.example.blog.model.Blog;
import com.example.blog.service.IBlogService;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
   private IBlogService blogService;
@Autowired
private ICategoryService iCategoryService;

    @GetMapping("/blog")
    public String displayListBlog(@PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable,
                                  Model model){
        model.addAttribute("blogList",blogService.displayListBlog(pageable));
        return "blogs";
    }
    @GetMapping("/create")
    public String getCreationForm(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList", iCategoryService.displayCategoryList());
        return "create";
    }
    @PostMapping("/create")
    public String createNewBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("message","Them moi thanh cong");
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
       if ( blogService.deleteBlog(id)){
           redirectAttributes.addFlashAttribute("message","xoa thanh cong");
       }else{
           redirectAttributes.addFlashAttribute("message","khong tim thay id");
       }

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable int id,Model model){

        model.addAttribute("blog",blogService.getBlogById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String editBlog(@ModelAttribute Blog blog ,RedirectAttributes redirectAttributes){
        blogService.editBlog(blog);
        redirectAttributes.addFlashAttribute("message","update thanh cong");
        return "redirect:/";
    }
}

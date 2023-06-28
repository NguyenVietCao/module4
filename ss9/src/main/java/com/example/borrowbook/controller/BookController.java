package com.example.borrowbook.controller;

import com.example.borrowbook.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public String showListBook(Model model){
        model.addAttribute("bookList",bookService.displayListBook());
        return "library";
    }

    @GetMapping("/detail/{id}")
    public String showListDetail(@PathVariable("id") int id ,Model model){
        model.addAttribute("book",bookService.getBookById(id));
        return "/detail";
    }
}

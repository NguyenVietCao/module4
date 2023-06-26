package com.example.user.controller;

import com.example.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    @RequestMapping("")
    public String getForm(Model model){
        model.addAttribute("user",new User());
        return "create";
    }
@PostMapping("/create")
    public String createUser(@Valid @ModelAttribute User user , BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "create";
        }
        return "list";
}
}

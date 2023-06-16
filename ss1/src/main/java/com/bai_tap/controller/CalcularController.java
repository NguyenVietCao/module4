package com.bai_tap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bai_tap.service.IChangeMoneyService;

@Controller
public class CalcularController {
    @Autowired
    private IChangeMoneyService changeMoneyService;

    @GetMapping("")
    public String greeting() {
        return "result";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam("usd") double money, Model model) {
        if (money < 0) {
            model.addAttribute("result" + " not format");
        } else {
            model.addAttribute("result", changeMoneyService.convertMoney(money));
        }
        return "result";
    }

}

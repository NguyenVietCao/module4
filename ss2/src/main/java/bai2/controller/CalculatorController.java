package bai2.controller;

import bai2.service.CalculatorServiceIplm;
import bai2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorServiceIplm ;
    @RequestMapping("/c")
    public String home(){
        return "displayCalculator";
    }
    @PostMapping("calculator")
    public String displayCalculator(@RequestParam("input1")int num1,
                                    @RequestParam("input2") int num2,
                                    @RequestParam("button")String button,
                                    Model model){
       ;

        model.addAttribute("result", calculatorServiceIplm.calculator( model,num1, num2, button));
        return "displayCalculator";
    }
}

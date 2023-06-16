package bai2.service;

import org.springframework.ui.Model;

public interface ICalculatorService {
    int calculator(Model model,int num1,int num2,String button);
}

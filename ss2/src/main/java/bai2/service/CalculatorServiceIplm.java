package bai2.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service
public class CalculatorServiceIplm implements ICalculatorService{
    @Override
    public int calculator(Model model,int num1,int num2,String button) {
        int result = 0;
        if(button.equals("addition")){
            result = num1 + num2;
        }else if(button.equals("subtraction")) {
            result = num1 - num2;
        }else if (button.equals("multiplication")){
            result = num1 * num2;
        }else if (button.equals("division")){
            if(num2==0){
                model.addAttribute("message","khong the chia het cho 0");
            }else {
            result = num1/num2;
        }
        }
        return result;
    }
}

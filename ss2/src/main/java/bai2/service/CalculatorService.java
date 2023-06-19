package bai2.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public int calculator(Model model,int num1,int num2,String button) {
        int result = 0;
        switch (button) {
            case "addition":
                result = num1 + num2;
                break;
            case "subtraction":
                result = num1 - num2;
                break;
            case "multiplication":
                result = num1 * num2;
                break;
            case "division":
                if (num2 == 0) {
                    model.addAttribute("message", "khong the chia het cho 0");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                break;
        }
        return result;
    }
}

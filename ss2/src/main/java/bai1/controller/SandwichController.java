package bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment,Model model) {
        if (condiment == null) {
            model.addAttribute("result","Chon gia Vi");
        }else {
            model.addAttribute("result","Gia vi cua sandwich la:" + Arrays.toString(condiment) );
        }
        return "home";
    }
}

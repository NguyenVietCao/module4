package com.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
@PostMapping
    public String dictionary(@RequestParam("input") String traslate , Model model){
//    model.addAttribute("traslate",traslate);
    Map<String,String> stringMap = new HashMap<>();

    stringMap.put("apple","tao");
    String result = "";
    for (String s:stringMap.keySet()) {
        if (traslate.equals(s)){
            result = stringMap.get(s);
        }
    }
    model.addAttribute("result",result);
    return "result";

}
}

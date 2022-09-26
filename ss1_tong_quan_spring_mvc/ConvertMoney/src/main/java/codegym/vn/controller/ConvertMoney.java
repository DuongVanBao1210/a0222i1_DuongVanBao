package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoney {


    @GetMapping("/convert")
    public String convert(){
        return "convert";
    }

    @PostMapping("/result")
    public String result(@RequestParam(value = "money") int money,
                         @RequestParam("value") String value,
                         Model model){
        float result = 0;
        switch (value){
            case "usd":
                result = money*23000;
                break;
            case "vnd":
                result = money/23000;
                break;
        }
        model.addAttribute("result",result);
        model.addAttribute("money", money);
        model.addAttribute("value",value);
        return "convert";
    }

}

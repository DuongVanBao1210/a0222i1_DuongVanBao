package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatedController {
    @GetMapping("/calc")
    public String calculatorForm(){
        return "calculator";
    }

    @PostMapping("/calc")
    public String result(@RequestParam("number1") double number1,
                         @RequestParam("number2") double number2,
                         @RequestParam("Submit") String method,
                         Model model){
        double result = 0;
        String message = "";
        switch (method){
            case "cong":
                result = number1 + number2;
                break;
            case "tru":
                result = number1 - number2;
                break;
            case "nhan":
                result = number1 * number2;
                break;
            case "chia":
                if(number2 == 0){
                    message = "Cant not divide by Zero";
                }
                else {
                    result = number1 / number2;
                }
                break;
        }
        model.addAttribute("result",result);
        model.addAttribute("message", message);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);

        return "calculator";

    }

}

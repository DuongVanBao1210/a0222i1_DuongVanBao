package codegym.vn.controller;

import codegym.vn.entity.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

    @GetMapping("/email")
    public String convert(){
        return "email";
    }

    @PostMapping("/info")
    public String result(@ModelAttribute("email") EmailService emailService, Model model){
        model.addAttribute("language", emailService.getLanguage());
        model.addAttribute("page", emailService.getPage());
        return "show";
    }
}

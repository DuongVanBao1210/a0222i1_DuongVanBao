package codegym.vn.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @GetMapping("/sandwich")
    public String sandwich(){
        return "index";
    }

    @PostMapping("/sandwich")
    public String save(@RequestParam("sandwich") String[] sandwich, Model model){
        model.addAttribute("sandwich", sandwich);
        return "index";
    }
}

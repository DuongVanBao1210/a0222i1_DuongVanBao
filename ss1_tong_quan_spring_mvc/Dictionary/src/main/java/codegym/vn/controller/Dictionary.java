package codegym.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {


    @GetMapping("/dictionary")
    public String dictionary(){
        return "home";
    }

    @PostMapping("/result")
    public String result(@RequestParam(value = "word") String word, Model model){
        String[] vn = {"xanh","do","cam","vang"};
        String[] eng = {"blue","red","orange","yellow"};
        for (int i =0;i<vn.length;i++){
            if(word.equals(vn[i]) ){
                model.addAttribute("result",eng[i]);
                break;
            }
            else model.addAttribute("result", "no found");
        }
        model.addAttribute("word", word);
        return "home";
    }
}

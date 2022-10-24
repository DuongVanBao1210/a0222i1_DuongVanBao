package com.example.quanlysanpham.controller;



import com.example.quanlysanpham.entity.ClassName;
import com.example.quanlysanpham.entity.Product;
import com.example.quanlysanpham.service.ProductService;
import com.example.quanlysanpham.validate.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService service;


    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public String showList(Model model,  @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  2;

        Page<Product> products = service.getAll( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("products",products );

        int numbers = products.getNumber();
        int totalItems = products.getNumberOfElements();
        int totalPages = products.getTotalPages();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "list";
    }

    @GetMapping("/create")
    public  String showForm(Model model){
        model.addAttribute("product", new Product());

        List<ClassName> classNames = service.getAllClasses();
        model.addAttribute("classNames", classNames);
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated  @ModelAttribute(value = "product") Product product,
                         BindingResult bindingResult, Model model){

        ProductValidate validate = new ProductValidate();
        validate.validate(product, bindingResult);
        if (bindingResult.hasErrors()) {

            List<ClassName> classNames = service.getAllClasses();
            model.addAttribute("classNames", classNames);
            return "create";
        }

        service.create(product);
        return "redirect:/product/list";
    }

    @GetMapping("/view")
    public  String viewByid(@RequestParam("id") String id, Model model)
    {
        Product product =  service.findById( Integer.parseInt(id));
            model.addAttribute("product", product)   ;
        List<ClassName> classNames = service.getAllClasses();
        model.addAttribute("classNames", classNames);
            return "view";
    }

    @GetMapping("/delete")
    public  String deleteByid(@RequestParam("id") String id, Model model)
    {
        service.delete( Integer.parseInt(id) );
        return "redirect:/product/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product){
        service.update(product);
        return "redirect:/product/list";
    }


    @GetMapping("/listClass")
    public  String listClass(Model model){

        List<ClassName> classNames = service.getAllClasses();
        model.addAttribute("classNames", classNames);
        return "listClass";
    }

    @GetMapping("/createClass")
    public  String createClass(Model model){
        model.addAttribute("class", new ClassName());
     return "createClassName" ;
    }

    @PostMapping("/createClass")
    public  String createClass(@Validated  @ModelAttribute("class") ClassName className){

        service.createClasses(className);
        return "createClassName" ;
    }


}

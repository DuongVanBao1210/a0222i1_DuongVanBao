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
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService service;
    private Path pathPic = Paths.get("src\\main\\resources\\static\\image\\");



    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public String showList(Model model,  @RequestParam(value = "page") Optional<Integer> page){
        int currentPage = page.orElse(1);
        int pageSize =  5;

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
                         BindingResult bindingResult,
                         @RequestParam(value= "filePicRequest") MultipartFile PicFile,
                         Model model){

        ProductValidate validate = new ProductValidate();
        validate.validate(product, bindingResult);

        if(   PicFile.isEmpty() ){
            FieldError e = new FieldError("product", "filePic",  "File Pic is empty" );
            bindingResult.addError(   e);
        }


        if (bindingResult.hasErrors()) {
            List<ClassName> classNames = service.getAllClasses();
            model.addAttribute("classNames", classNames);
            return "create";
        }

        try {

            InputStream inputStreamPic = PicFile.getInputStream();
            String extentionPic =  PicFile.getOriginalFilename().substring(PicFile.getOriginalFilename().lastIndexOf('.') + 1);
            String fileNamePic =  product.getName() + "-"  + System.currentTimeMillis()  + "."+  extentionPic ;
            Files.copy(inputStreamPic, pathPic.resolve( fileNamePic), StandardCopyOption.REPLACE_EXISTING);
            product.setFilePic(fileNamePic);
        } catch (IOException e) {
            e.printStackTrace();
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
        int idDelete = Integer.parseInt(id);
        Product product = service.findById(idDelete) ;
        try {
            Files.delete( pathPic.resolve( product.getFilePic()));
            System.out.println("Xoa thanh cong");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Xoa that bai");
        }
        service.delete(  idDelete );

        return "redirect:/product/list";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("product") Product product,
                         @RequestParam(value= "filePicRequest") MultipartFile PicFile){


        if(   !PicFile.isEmpty() ){ //neu co file anh moi phai xoa file cu chon file moi
            try {
                // xoa file anh cu
                Files.delete( pathPic.resolve( product.getFilePic()));
                // thay doi file  moi
                InputStream inputStreamPic = PicFile.getInputStream();
                String extentionPic =  PicFile.getOriginalFilename().substring(PicFile.getOriginalFilename().lastIndexOf('.') + 1);
                String fileNamePic =  product.getName() + "-"  + System.currentTimeMillis()  + "."+  extentionPic ;
                Files.copy(inputStreamPic, pathPic.resolve( fileNamePic), StandardCopyOption.REPLACE_EXISTING);

                product.setFilePic(fileNamePic);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
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

package codegym.vn.muonsach.controller;


import codegym.vn.muonsach.entity.Book;
import codegym.vn.muonsach.service.BookService;
import codegym.vn.muonsach.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Console;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CardService cardService;

    @GetMapping("/list")
    public String showList(Model model, @RequestParam(value = "page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<Book> books = bookService.getListBook( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("books",books );

        int numbers = books.getNumber();
        int totalItems = books.getNumberOfElements();
        int totalPages = books.getTotalPages();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "book/listBook";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/create")
    public  String create(@Valid @ModelAttribute("book")  Book book,  BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()) {
            return "book/create";
        }
        bookService.saveBook(book);
        return "redirect:/books/list";

    }

    @PostMapping("/delete")
    public  String delete( @RequestParam(value= "idDelete") String idDelete, Model model){
        Long id = Long.parseLong(idDelete);
        Book book = bookService.getById(id);
        bookService.delete( book );
        return "redirect:/books/list";
    }

    @GetMapping("/update")
    public String update( @RequestParam(value= "idUpdate") String idUpdate, Model model){

        Long id = Long.parseLong(idUpdate);
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "book/update";
    }

    @PostMapping("/update")
    public  String update(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors()){
//            model.addAttribute("book", book);
            return "book/update";
        }
        bookService.saveBook( book);
        return "redirect:/books/list";

    }
}

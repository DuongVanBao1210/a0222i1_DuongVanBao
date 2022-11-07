package codegym.vn.muonsach.controller;


import codegym.vn.muonsach.entity.Book;
import codegym.vn.muonsach.entity.LibraryCard;
import codegym.vn.muonsach.service.BookService;
import codegym.vn.muonsach.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private CardService cardService;
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String showList(Model model, @RequestParam(value = "page") Optional<Integer> page) {
        int currentPage = page.orElse(1);
        int pageSize =  5;

        Page<LibraryCard> cards = cardService.getListCard( PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("cards",cards );

        int numbers = cards.getNumber();
        int totalItems = cards.getNumberOfElements();
        int totalPages = cards.getTotalPages();

        model.addAttribute("totalItems", totalItems);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("numbers", numbers);
        return "card/listCard";
    }

    @GetMapping("/create")
    public String create(@RequestParam(value = "idBook", defaultValue = "0") String idBookAA,Model model) {

        model.addAttribute("card", new LibraryCard());
        List<Book> books  = bookService.getListBook();
        model.addAttribute("books", books);
        model.addAttribute("idssss", Long.parseLong(idBookAA));
        return "card/create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("card") LibraryCard card,
                         @RequestParam(value = "idBook", defaultValue = "0") String idBook,
                         BindingResult bindingResult, Model model){
        if( bindingResult.hasErrors()){
            List<Book> books  = bookService.getListBook();
            model.addAttribute("books", books);
            return "card/create";
        }
        cardService.save(card);
        return "redirect:/cards/";

    }

    @GetMapping("/return")
    public String formReturn( @RequestParam(value = "idReturn", defaultValue = "") String idReturn, Model model){
            idReturn= idReturn.trim();
            LibraryCard card = cardService.getById(idReturn);
            if( card == null)
                return "template/error";
            else

            {
                model.addAttribute("card", card);
                model.addAttribute("idReturn", idReturn);

                return "card/returnBook";
            }
    }

    @PostMapping("/return")
    public String formReturn(@RequestParam("idReturn") String idReturn){
        LibraryCard card = cardService.getById(idReturn);
        cardService.delete( card );
        Book book = bookService.getById( card.getBook().getId());
        int sluong = book.getQuantity();
        book.setQuantity( sluong + 1 );
        bookService.saveBook( book );

        return "redirect:/cards/";
    }

}

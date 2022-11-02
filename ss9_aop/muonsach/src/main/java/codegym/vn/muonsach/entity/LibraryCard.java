package codegym.vn.muonsach.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class LibraryCard {


    @Id
    @GeneratedValue(generator = "my_generator")
    @GenericGenerator(name = "my_generator",
        strategy = "codegym.vn.muonsach.generator.MyGenerator")
    private String cardId;

    @NotBlank(message = "{notempty}")
    private String cardName;

    @ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Book book;



    public LibraryCard(String cardId, @NotBlank(message = "{notempty}") String cardName) {
        this.cardId = cardId;
        this.cardName = cardName;
    }

    public LibraryCard() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public LibraryCard(String cardId, @NotBlank(message = "{notempty}") String cardName, Book book) {
        this.cardId = cardId;
        this.cardName = cardName;
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

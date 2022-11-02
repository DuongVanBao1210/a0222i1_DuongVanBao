package codegym.vn.muonsach.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @NotBlank(message = "{notempty}")
    private String author;

    @Min(value =1 , message="phai lon hon 0")
    private int quantity;
//
//    @ManyToOne
//    @JoinColumn( name = "cardId", referencedColumnName = "cardId")
//    private LibraryCard card;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "book")
    private List<LibraryCard> libraries;

    public List<LibraryCard> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryCard> libraries) {
        this.libraries = libraries;
    }

    public Book(Long id, String name, @NotBlank(message = "{notempty}") String author, @Min(value = 1, message = "phai lon hon 0") int quantity, List<LibraryCard> libraries) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.libraries = libraries;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




}

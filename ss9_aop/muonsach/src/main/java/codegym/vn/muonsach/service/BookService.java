package codegym.vn.muonsach.service;

import codegym.vn.muonsach.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Page<Book> getListBook(Pageable pageable);
    void saveBook ( Book book );
    void delete( Book book );
    Book getById( Long id);
    List<Book> getListBook();


}

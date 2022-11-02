package codegym.vn.muonsach.service;

import codegym.vn.muonsach.entity.Book;
import codegym.vn.muonsach.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookServiceImpl  implements BookService{

    @Autowired
    protected BookRepository bookRepository;

    @Override
    public Page<Book> getListBook(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public void saveBook(Book book) {
                bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public Book getById(Long id) {
        return  bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getListBook() {
        return bookRepository.findAll();
    }
}

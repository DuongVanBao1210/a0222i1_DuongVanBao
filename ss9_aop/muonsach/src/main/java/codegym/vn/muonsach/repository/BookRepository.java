package codegym.vn.muonsach.repository;

import codegym.vn.muonsach.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface  BookRepository extends JpaRepository<Book, Long> {
}

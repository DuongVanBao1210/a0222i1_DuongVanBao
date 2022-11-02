package codegym.vn.muonsach.repository;


import codegym.vn.muonsach.entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<LibraryCard, String> {
}

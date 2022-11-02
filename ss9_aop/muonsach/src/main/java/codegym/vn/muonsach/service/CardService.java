package codegym.vn.muonsach.service;

import codegym.vn.muonsach.entity.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CardService {

    Page<LibraryCard> getListCard(Pageable pageable);
    void save(LibraryCard libraryCard);
    void delete(LibraryCard libraryCard);
    LibraryCard  getById(String id);
}

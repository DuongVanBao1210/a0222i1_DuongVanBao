package codegym.vn.muonsach.service;


import codegym.vn.muonsach.entity.LibraryCard;
import codegym.vn.muonsach.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {


    @Autowired
    private CardRepository cardRepository;


    @Override
    public Page<LibraryCard> getListCard(Pageable pageable) {
        return cardRepository.findAll(pageable);
    }

    @Override
    public void save(LibraryCard libraryCard) {
            cardRepository.save(libraryCard);
    }

    @Override
    public void delete(LibraryCard libraryCard) {
     cardRepository.delete(libraryCard);
    }

    @Override
    public LibraryCard getById(String id) {
        return cardRepository.findById(id).orElse(null);
    }


}

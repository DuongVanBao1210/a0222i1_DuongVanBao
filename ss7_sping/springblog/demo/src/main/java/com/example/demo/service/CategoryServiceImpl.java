package com.example.demo.service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


//@Service("categoryService")
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepositoryJpa categotyRepository;
//    @Autowired
//    public  CategoryServiceImpl ( CategoryRepositoryJpa categotyRepository){
//        this.categotyRepository = categotyRepository;
//    }

    @Override
    public void create(Category category) {
        categotyRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categotyRepository.save(category);
    }

    @Override
    public void delete(String id) {
        categotyRepository.delete(categotyRepository.findById(Integer.parseInt(id)).orElse(null));
    }

    @Override
    public List<Category> getAllCategory() {
        return categotyRepository.findAll();
    }

    @Override
    public Page<Category> findAllPage(Pageable pageable) {
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return categotyRepository.findAll(pageable);

    }


//    @Override
//    public Page<Category> findAllPage(Pageable pageable) {
//        return categotyRepository.findAll( pageable);
//    }

}

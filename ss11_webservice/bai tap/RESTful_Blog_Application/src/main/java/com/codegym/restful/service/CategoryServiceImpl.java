package com.codegym.restful.service;

import com.codegym.restful.entity.Category;
import com.codegym.restful.repository.CategoryRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepositoryJpa categotyRepository;

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
        categotyRepository.delete(
                categotyRepository.findById(Integer.parseInt(id.trim())).orElse(null));

    }

    @Override
    public List<Category> getAllCategory() {
        return categotyRepository.findAll();
    }

    @Override
    public Page<Category> findAllPage(Pageable pageable) {
        return categotyRepository.findAll(pageable);

    }

}

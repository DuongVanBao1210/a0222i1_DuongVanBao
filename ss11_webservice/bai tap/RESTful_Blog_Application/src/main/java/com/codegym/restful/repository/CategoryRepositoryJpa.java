package com.codegym.restful.repository;


import com.codegym.restful.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CategoryRepositoryJpa extends JpaRepository<Category, Integer> {

}

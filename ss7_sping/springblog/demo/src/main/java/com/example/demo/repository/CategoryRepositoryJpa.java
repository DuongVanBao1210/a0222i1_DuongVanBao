package com.example.demo.repository;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CategoryRepositoryJpa extends JpaRepository<Category, Integer> {

//    @Query(  value = "select c from Category")
//    Page<Category> findAllPage(Pageable pageable);
}

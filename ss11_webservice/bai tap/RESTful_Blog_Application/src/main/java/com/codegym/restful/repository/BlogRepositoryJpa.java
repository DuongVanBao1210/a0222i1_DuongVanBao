package com.codegym.restful.repository;

import com.codegym.restful.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BlogRepositoryJpa extends JpaRepository<Blog, Integer> {

    @Query
    List<Blog> findAllByTitleContaining(String search);
}

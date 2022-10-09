package com.vn.repository;

import com.vn.entity.Blog;
import com.vn.entity.Theme;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class BlogRepositoryImpl implements  BlogRepositoty {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Modifying
    public void create(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void delete(String id) {
        entityManager.remove( findById(id));
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs = entityManager
                .createQuery("select p from  Blog p ")
                .getResultList();

        return  blogs;
    }

    @Override
    public Blog findById(String id) {
        return entityManager.find(Blog.class, Integer.parseInt(id));
    }

    @Override
    public List<Theme> getAllTheme() {
        List<Theme> blogs = entityManager
                .createQuery("select p from  Theme p ")
                .getResultList();

        return  blogs;
    }
}

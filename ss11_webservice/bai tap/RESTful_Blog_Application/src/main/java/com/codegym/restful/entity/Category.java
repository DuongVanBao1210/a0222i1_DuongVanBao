package com.codegym.restful.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = " int")
    private int idTheme;
    private String nameTheme;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "category")
    @JsonBackReference
    private List<Blog> blogs = new ArrayList<>();


    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category() {
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getNameTheme() {
        return nameTheme;
    }

    public void setNameTheme(String nameTheme) {
        this.nameTheme = nameTheme;
    }

    public Category(int idTheme, String nameTheme) {
        this.idTheme = idTheme;
        this.nameTheme = nameTheme;
    }

    @Override
    public String toString() {
        return nameTheme;
    }
}

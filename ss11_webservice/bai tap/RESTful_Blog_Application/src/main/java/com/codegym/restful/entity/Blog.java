package com.codegym.restful.entity;


import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = " int  ")
    private int id;
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    @Column(columnDefinition = " date  ")
    private String dateWrite;

    @ManyToOne
    @JoinColumn(name = "idTheme")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category themes) {
        this.category = themes;
    }


    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateWrite() {
        return dateWrite;
    }

    public void setDateWrite(String dateWrite) {
        this.dateWrite = dateWrite;
    }

    public Blog(int id, String title, String content, String dateWrite) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateWrite = dateWrite;
    }


}

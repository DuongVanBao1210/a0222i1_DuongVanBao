package com.vn.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "bai_viet")
public class Blog {

    @Id
    @Column(name = "id", columnDefinition = " int AUTO_INCREMENT ")
    private int id;
    private String title;
    @Column( columnDefinition = " text  ")
    private String content;
    @Column( columnDefinition = " date  ")
    private String dateWrite;
    private int idTheme;

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

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public Blog(int id, String title, String content, String dateWrite, int idTheme) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.dateWrite = dateWrite;
        this.idTheme = idTheme;
    }
}

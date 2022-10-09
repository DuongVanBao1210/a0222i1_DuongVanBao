package com.vn.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Theme {

    @Id
    private int idTheme;
    private String nameTheme;

    public Theme() {
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

    public Theme(int idTheme, String nameTheme) {
        this.idTheme = idTheme;
        this.nameTheme = nameTheme;
    }
}

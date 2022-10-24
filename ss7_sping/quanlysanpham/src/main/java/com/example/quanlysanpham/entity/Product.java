package com.example.quanlysanpham.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "{notempty}")
    private String name;
    private boolean status;

    @Column(name = "expiry_date", columnDefinition = " date ")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;

    @Min(value = 0, message = "phai lon hon 0")
    private double price;

    @NotBlank(message = "{notempty}")
    private String country;


    @ManyToOne
    @JoinColumn( name = "classId", referencedColumnName = "classId")
    private ClassName  className;


    public Product() {
    }

    public Product(int id, String name, boolean status, Date expiryDate, double price, String country) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.expiryDate = expiryDate;
        this.price = price;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }


    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

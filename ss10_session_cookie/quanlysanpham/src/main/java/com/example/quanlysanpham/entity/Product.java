package com.example.quanlysanpham.entity;


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

    private String filePic;


    @Transient
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product(int id, @NotBlank(message = "{notempty}") String name, boolean status, Date expiryDate, @Min(value = 0, message = "phai lon hon 0") double price, String filePic, int count, @NotBlank(message = "{notempty}") String country, ClassName className) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.expiryDate = expiryDate;
        this.price = price;
        this.filePic = filePic;
        this.count = count;
        this.country = country;
        this.className = className;
    }

    @NotBlank(message = "{notempty}")
    private String country;


    @ManyToOne
    @JoinColumn( name = "classId", referencedColumnName = "classId")
    private ClassName  className;


    public Product() {
    }

    public Product(int id, @NotBlank(message = "{notempty}") String name, boolean status, Date expiryDate, @Min(value = 0, message = "phai lon hon 0") double price, String filePic, @NotBlank(message = "{notempty}") String country, ClassName className) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.expiryDate = expiryDate;
        this.price = price;
        this.filePic = filePic;
        this.country = country;
        this.className = className;
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

    public String getFilePic() {
        return filePic;
    }

    public void setFilePic(String urlPic) {
        this.filePic = urlPic;
    }
}

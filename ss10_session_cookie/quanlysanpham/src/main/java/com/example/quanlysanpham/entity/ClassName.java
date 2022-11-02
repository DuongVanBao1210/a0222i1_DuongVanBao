package com.example.quanlysanpham.entity;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class ClassName {
    @Id
    @Column(length = 20)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String classId;

    @NotBlank(message = "{notempty}")
    @Size(max = 5, min = 5,message="phai co 5 ky tu")
    private String name;


    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "className")
    private Set<Product> products;


    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public ClassName(String classCode, String name) {
        this.classId = classCode;
        this.name = name;
    }

    public ClassName() {
    }

    public String getClassCode() {
        return classId;
    }

    public void setClassCode(String classCode) {
        this.classId = classCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String className) {
        this.name = className;
    }
}

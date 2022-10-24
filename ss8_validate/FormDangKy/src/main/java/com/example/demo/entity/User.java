package com.example.demo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotBlank(message = "{notempty}")
    @Size(max = 45, min = 5, message = "firstname phải lơn hơn 5 nho hon 45")
    private String firstname;

    @NotBlank(message = "{notempty}")
    @Size(max = 45, min = 5, message = "lastname phải lơn hơn 5 nho hon 45")
    private String lastname;


    //    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private Date birthdate;


    @Min(value = 18, message = "{ageMin}")
    private int age;

    @Email(message = "email khong dung dinh dang")
    private String email;

    public User() {
    }

    public User(int id, @NotBlank(message = "{notempty}") @Min(value = 5, message = "{nameMin}") @Max(value = 45, message = "{nameMax}") String firstname, @NotBlank(message = "{notempty}") @Min(value = 5, message = "{nameMin}") @Max(value = 45, message = "{nameMax}") String lastname, Date birthdate, @Min(value = 18, message = "{ageMin}") int age, @Email String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.age = age;
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

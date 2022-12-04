package com.can.rest.webservices.helloworldwebservices.User;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;


@JsonIgnoreProperties("birthDate")
//@JsonFilter("UserFilter")
public class User {
    private Integer id;
    @Size(min =2 , message = "Name should have at least 2 characters")
    private String name;
    @Past(message = "birth date must be before the current date")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate bdate)
    {
        this.id = id;
        this.name= name;
        this.birthDate = bdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

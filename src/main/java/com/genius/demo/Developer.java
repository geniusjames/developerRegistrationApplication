package com.genius.demo;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Entity
@Table
public class Developer {

    @Id
    @SequenceGenerator(
            name = "developer_sequence",
            sequenceName = "developer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "developer_sequence"

    )
    private long id;
    private String name;
    private String stack;

    @Transient
    private int age;

    private LocalDate dateOfBirth;
    private String email;

    public Developer(long id, String name, String stack, LocalDate dateOfBirth, String email) {
        this.id = id;
        this.name = name;
        this.stack = stack;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Developer() {

    }

    public Developer(String name, String stack, LocalDate dateOfBirth, String email) {

        this.name = name;
        this.stack = stack;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears() ;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stack='" + stack + '\'' +
                ", age=" + age +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}

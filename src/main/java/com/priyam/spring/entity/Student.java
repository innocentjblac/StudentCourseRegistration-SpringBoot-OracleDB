package com.priyam.spring.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Student {
//This is a demo comment
    //Excuse the french ...
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    public Student(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUSTOMER_TABLE_TEST_PRIYAM_SEQ")
    @SequenceGenerator(name = "CUSTOMER_TABLE_TEST_PRIYAM_SEQ", sequenceName = "CUSTOMER_TABLE_TEST_PRIYAM_SEQ", allocationSize = 1)
    private int id;
    @NotNull
    @Length(min = 1,max = 20)
    private String name;
    @NotNull
    @Length(min = 3,max = 3)
    private String phone;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Student(int id, String name, String phone) {
        super();
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
    public Student() {
        super();
    }





}
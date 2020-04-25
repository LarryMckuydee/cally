package com.larryco.cally.models;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// when include @DiscriminatorColumn, ddl-auto having issue to create table
@DiscriminatorColumn(name = "level") //Hibernate by default use DTYPE as column name
// for STI, column name "type" are usually use as a reserved column from Ruby On Rails, while Laravel not support but it just my preference
@Table(name = "employees")
public abstract  class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "* Please Enter First Name")
    private String name;

    @Email(message = "* Please Enter Valid Email Address")
    @NotEmpty(message = " * Please Provide Email Address")
    @Column(name = "email")
    private String email;

}
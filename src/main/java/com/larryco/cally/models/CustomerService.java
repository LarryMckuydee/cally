package com.larryco.cally.models;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Entity
@DiscriminatorValue("1")
public class CustomerService extends Employee{
}
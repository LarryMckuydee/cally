package com.larryco.cally.models;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Value;

@Entity
@DiscriminatorValue("2")
public class TechnicalLead extends Employee {
}
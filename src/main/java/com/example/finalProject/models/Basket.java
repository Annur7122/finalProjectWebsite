package com.example.finalProject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="basket")
@Getter
@Setter
public class Basket extends BaseModel {
    @Column(name="name")
    private String name;

    @ManyToOne
    private Offers offer;
}

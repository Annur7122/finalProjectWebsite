package com.example.finalProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "offers")
@Getter
@Setter
public class Offers extends BaseModel {
    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name="status")
    private int status;

    @ManyToOne
    private Types type;

    @ManyToMany
    private List<User> user;

}

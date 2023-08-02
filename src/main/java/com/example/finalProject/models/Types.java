package com.example.finalProject.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="types")
@Getter
@Setter
public class Types extends BaseModel {
    @Column(name="name")
    private String name;

}

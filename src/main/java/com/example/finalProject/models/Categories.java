package com.example.finalProject.models;


import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="task_categories")
@Getter
@Setter
public class Categories extends BaseModel {
    @Column(name="name")
    private String name;
}

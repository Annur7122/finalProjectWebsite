package com.example.finalProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comments")
@Getter
@Setter

public class Comments  extends BaseModel  {
    @Column(name="text")
    private String text;

    @ManyToOne
    private Offers offer;

    @ManyToOne
    private User user;
}


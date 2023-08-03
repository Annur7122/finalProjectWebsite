package com.example.finalProject.dto;

import com.example.finalProject.models.Types;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OffersDTO {
   private Long id;
   private String name;
   private String description;
   private int price;
   private Types type;
}

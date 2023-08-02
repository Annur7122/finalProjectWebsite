package com.example.finalProject.mapper;


import com.example.finalProject.dto.OffersDTO;
import com.example.finalProject.models.Offers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OffersMapper {
    OffersDTO toDTO(Offers offer);
    Offers toModel(OffersDTO offersDTO);
    List<OffersDTO> toDtoList(List<Offers> offersList);
    List<Offers> toModelList(List<OffersDTO> offersList);
}

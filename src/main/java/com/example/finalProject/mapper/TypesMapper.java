package com.example.finalProject.mapper;


import com.example.finalProject.dto.OffersDTO;
import com.example.finalProject.dto.TypesDTO;
import com.example.finalProject.models.Offers;
import com.example.finalProject.models.Types;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypesMapper {
    TypesDTO toDTO(Types types);
    Types toModel(TypesDTO typesDTO);
    List<TypesDTO> toDtoList(List<Types> typesList);
    List<Types> toModelList(List<TypesDTO> typesList);
}

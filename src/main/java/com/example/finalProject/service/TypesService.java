package com.example.finalProject.service;


import com.example.finalProject.dto.OffersDTO;
import com.example.finalProject.dto.TypesDTO;
import com.example.finalProject.mapper.OffersMapper;
import com.example.finalProject.mapper.TypesMapper;
import com.example.finalProject.models.Offers;
import com.example.finalProject.models.Types;
import com.example.finalProject.reposritory.OffersRepository;
import com.example.finalProject.reposritory.TypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TypesService {
    private final TypesRepository typesRepository;
    private final TypesMapper typesMapper;

    public List<TypesDTO> getTypes(){
        return typesMapper.toDtoList(typesRepository.findAll());
    }
    public List<Types> getAllTypes(){
        return typesRepository.findAll();
    }

    public TypesDTO getTypes(Long id){
        return typesMapper.toDTO(typesRepository.findById(id).orElse(new Types()));
    }
    public Types getTypeById(Long id){
        return typesRepository.findById(id).orElse(new Types());
    }
    public TypesDTO addTypes(TypesDTO type){
        return typesMapper.toDTO(typesRepository.save(typesMapper.toModel(type)));
    }

    public TypesDTO updateTypes(TypesDTO type){
        return typesMapper.toDTO(typesRepository.save(typesMapper.toModel(type)));
    }

    public void deleteTypes(Long id){
        typesRepository.deleteById(id);
    }


}

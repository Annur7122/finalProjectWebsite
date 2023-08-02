package com.example.finalProject.api;


import com.example.finalProject.dto.OffersDTO;
import com.example.finalProject.dto.TypesDTO;
import com.example.finalProject.service.OffersService;
import com.example.finalProject.service.TypesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/type")
@RequiredArgsConstructor
public class TypesRestController {
    private final TypesService typesService;

    @GetMapping
    public List<TypesDTO> typesList(){
        System.out.println(typesService.getTypes());
        return typesService.getTypes();
    }

    @GetMapping(value="{id}")
    public TypesDTO getType(@PathVariable(name = "id") Long id){
        return typesService.getTypes(id);
    }

    @PostMapping
    public TypesDTO addType(@RequestBody TypesDTO type) {
        return  typesService.addTypes(type);
    }

    @PutMapping
    public TypesDTO updateType(@RequestBody TypesDTO type){
        return typesService.updateTypes(type);
    }

    @DeleteMapping(value = "{id}")
    public void deleteType(@PathVariable(name = "id") Long id){
        typesService.deleteTypes(id);
    }

}

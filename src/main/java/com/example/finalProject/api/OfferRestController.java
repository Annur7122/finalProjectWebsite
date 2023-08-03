package com.example.finalProject.api;


import com.example.finalProject.dto.OffersDTO;

import com.example.finalProject.models.Offers;
import com.example.finalProject.service.CommentsService;
import com.example.finalProject.service.OffersService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="/offer")
@RequiredArgsConstructor
public class OfferRestController {
    private final OffersService offersService;
    private final CommentsService commentsService;

    @GetMapping
    public List<OffersDTO> offersList(){
        return offersService.getOffers();
    }

    @GetMapping(value="{id}")
    public OffersDTO getOffer(@PathVariable(name = "id") Long id){
        return offersService.getOffer(id);
    }

    @PostMapping
    public OffersDTO addOffer(@RequestBody OffersDTO offer) {
        return  offersService.addOffer(offer);
    }

    @PutMapping
    public OffersDTO updateOffer(@RequestBody OffersDTO offer){
        return offersService.updateOffer(offer);
    }

    @DeleteMapping(value = "{id}")
    public void deleteOffer(@PathVariable(name = "id") Long id){
        Offers offer = offersService.getOfferById(id);
        commentsService.removeAllFromOffer(offer);
        offersService.deleteOffer(id);
    }

}

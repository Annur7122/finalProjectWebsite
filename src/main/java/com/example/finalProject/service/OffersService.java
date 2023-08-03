package com.example.finalProject.service;


import com.example.finalProject.dto.OffersDTO;
import com.example.finalProject.mapper.OffersMapper;
import com.example.finalProject.models.Offers;
import com.example.finalProject.models.User;
import com.example.finalProject.reposritory.OffersRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OffersService {
    private final OffersRepository offersRepository;
    private final OffersMapper offersMapper;
    private final UserService userService;
    public Offers getOfferById(Long id){
        return offersRepository.findById(id).orElse(null);
    }

    public List<OffersDTO> getOffers(){
        return offersMapper.toDtoList(offersRepository.findAll());
    }

    public List<Offers> getAllOffer(){return offersRepository.findAll();}

    public List<Offers> getAllOffersByUser(User user1){
        return offersRepository.findAllByUserEquals(user1);
    }

    public List<Offers> getOffersByUser(User user){
        if (offersRepository != null) {
            return offersRepository.findAllByUserEquals(user);
        }
        // Если commentsRepository равно null, верните пустой список или выполните другие действия в зависимости от вашей логики
        return Collections.emptyList();
    }

    public void addUser(Long userId, Long offerId){
        Offers offer = getOfferById(offerId);
        User user = userService.getUserById(userId);

        if(offer.getUser() != null && offer.getUser().size() > 0){
            if(!offer.getUser().contains(user))offer.getUser().add(user);
        }else{
            List<User> userList = new ArrayList<>();
            userList.add(user);
            offer.setUser(userList);
        }
        offersRepository.save(offer);
    }

    public void removeUser(Long userId, Long offerId){
        Offers offer = getOfferById(offerId);
        User user = userService.getUserById(userId);

        if(offer.getUser() != null && offer.getUser().size() > 0){
            offer.getUser().remove(user);
        }

        offersRepository.save(offer);
    }

    public OffersDTO getOffer(Long id){
        return offersMapper.toDTO(offersRepository.findById(id).orElse(new Offers()));
    }

    public OffersDTO addOffer(OffersDTO offer){
        return offersMapper.toDTO(offersRepository.save(offersMapper.toModel(offer)));
    }

    public OffersDTO updateOffer(OffersDTO offer){
        return offersMapper.toDTO(offersRepository.save(offersMapper.toModel(offer)));
    }

    public void updateOffers(Offers offer){
        offersRepository.save(offer);
    }
    public void deleteOffer(Long id){
        offersRepository.deleteById(id);
    }


}

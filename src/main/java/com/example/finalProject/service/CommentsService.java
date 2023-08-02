package com.example.finalProject.service;


import com.example.finalProject.dto.OffersDTO;
import com.example.finalProject.mapper.OffersMapper;
import com.example.finalProject.models.Comments;
import com.example.finalProject.models.Offers;
import com.example.finalProject.reposritory.CommentsRepository;
import com.example.finalProject.reposritory.OffersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;

    public List<Comments> getCommentsByOffer(Offers offer){
        if (commentsRepository != null) {
            return commentsRepository.findAllByOfferEquals(offer);
        }

        return Collections.emptyList();
    }

    public void removeAllFromOffer(Offers offer){
        if (commentsRepository != null) {
            List<Comments> commentsList = commentsRepository.findAllByOfferEquals(offer);
            for(Comments comment : commentsList){
                commentsRepository.delete(comment);
            }
        }
    }

    public void saveOrUpdateComment(Comments comment){
             commentsRepository.save(comment);
    }

}

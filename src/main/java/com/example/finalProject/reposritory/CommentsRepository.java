package com.example.finalProject.reposritory;

import com.example.finalProject.models.Comments;
import com.example.finalProject.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    public List<Comments> findAllByOfferEquals(Offers offers);

}

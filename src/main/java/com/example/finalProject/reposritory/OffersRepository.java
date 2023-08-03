package com.example.finalProject.reposritory;

import com.example.finalProject.models.Comments;
import com.example.finalProject.models.Offers;
import com.example.finalProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.ArrayList;
import java.util.List;

public interface OffersRepository extends JpaRepository<Offers, Long> {
    public List<Offers> findAllByUserEquals(User user);

}

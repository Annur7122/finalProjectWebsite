package com.example.finalProject.reposritory;

import com.example.finalProject.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
}

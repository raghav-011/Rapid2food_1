package com.rapid2food.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapid2food.blog.entities.Category;



public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
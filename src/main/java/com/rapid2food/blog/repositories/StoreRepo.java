package com.rapid2food.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rapid2food.blog.entities.Category;
import com.rapid2food.blog.entities.Store;
import com.rapid2food.blog.entities.User;

public interface StoreRepo extends JpaRepository<Store,Integer> {

	List<Store>findByUser(User user);
	List<Store>findByCategory(Category category);
	List<Store>findByTitle(String title);
}
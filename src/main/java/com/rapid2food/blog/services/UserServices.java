package com.rapid2food.blog.services;

import java.util.List;

import com.rapid2food.blog.payloads.UserDTO;

public interface UserServices {
	UserDTO createUSer(UserDTO User);
	UserDTO updateUser(UserDTO User,Integer userID);
	UserDTO getUserById(Integer userID);
	List<UserDTO> getALLUsers();
	void deleteUser(Integer userID);
}


// entities ko direct hum services nhi denge
// islia hum ek payload UserDTO class bna lenge 
// Advantage kya hoga hum ab new columns add kerka dynamicaaly insertion kr skte hai
// aur userdto ko humdirect user se hi lenge or isko hum expose bhi kr skte hai
package com.rapid2food.blog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rapid2food.blog.payloads.UserDTO;
import com.rapid2food.blog.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
  
	@Autowired 
	private UserServices userservices;
	// POST-create user
	
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto){
		UserDTO createUserDto=this.userservices.createUSer(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	// PUT-update user
	@PutMapping("/{userid}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDto,@PathVariable("userid") Integer uid)
	{
		UserDTO userupdate=this.userservices.updateUser(userDto, uid);
		return ResponseEntity.ok(userupdate);
	}
	
	
	// Delete delete user
	@DeleteMapping("/{userid}")
	public ResponseEntity<?> deleteUser(@PathVariable("userid") Integer uid)
	{
		this.userservices.deleteUser(uid);
		return new ResponseEntity<Object>(Map.of("message","User Deleted Successfully"),HttpStatus.OK);	
	}  
	
	// GET - All user get
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>>getAllUsers()
	{
		return ResponseEntity.ok(this.userservices.getALLUsers());
	}
	
	// GET - All user get
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
		@GetMapping("/{userid}")
		public ResponseEntity<UserDTO> getSingleUser(@PathVariable("userid") Integer uid)
		{
			return  ResponseEntity.ok(this.userservices.getUserById(uid));	
		}
}

// USERDTO islia bnya hai kyuki hum apne user ko directly expose na kre should follow MVC architecture



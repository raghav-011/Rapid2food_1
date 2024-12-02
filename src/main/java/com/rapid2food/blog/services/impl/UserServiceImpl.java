 package com.rapid2food.blog.services.impl;
import java.util.List;
import java.util.stream.Collectors;
import com.rapid2food.blog.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rapid2food.blog.repositories.*;
import com.rapid2food.blog.entities.User;
import com.rapid2food.blog.payloads.UserDTO;
import com.rapid2food.blog.services.UserServices;


@Service 
public class UserServiceImpl implements UserServices

{
	
	@Autowired
	private UserRepo userRepo;
	
	
	@Override
	public UserDTO createUSer(UserDTO userdto) {
		// TODO Auto-generated method stub
		User user=this.dtoToUser(userdto);
		User savedUser = this.userRepo.save(user); 
		return this.userToDto(savedUser); 
	}
	
	@Override
	public UserDTO updateUser(UserDTO userDTO, Integer userID) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userID).orElseThrow( ()-> new ResourceNotFoundException("User "," id ",userID));
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		User updateduser=this.userRepo.save(user);
		UserDTO userdto1=this.userToDto(updateduser);
		return userdto1;
	}

	@Override
	public UserDTO getUserById(Integer userID) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userID).orElseThrow(()-> new ResourceNotFoundException("User "," id ",userID));
		return this.userToDto(user);
	}

	@Override
	public List<UserDTO> getALLUsers() {
		// TODO Auto-generated method stub
		List<User> users=this.userRepo.findAll();
		List<UserDTO> userdto= users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userdto; 
	}

	@Override
	public void deleteUser(Integer userID) {
		// TODO Auto-generated method stub
		User user=this.userRepo.findById(userID).orElseThrow(()-> new ResourceNotFoundException("User "," id ",userID));
		this.userRepo.delete(user);
	}
	
	// Convert UserDTO to actual user
	public User dtoToUser(UserDTO userDto)
	{
		User user=new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setRegistrationNo(userDto.getRegistrationNo());
		return user;
	}
	
	// Convert actual to UserDTO
	public UserDTO userToDto(User user)
	{
		UserDTO userdto=new UserDTO();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setRegistrationNo(user.getRegistrationNo());
		return userdto;
	}

}


/*

In STS (Spring Tool Suite), @Autowired is a Spring framework annotation used for automatic dependency injection.

Dependency Injection (DI) is a design pattern used to remove the dependency of an object on its dependencies. 
In other words, it is a technique to achieve loose coupling between classes.

When a class has a dependency on another class, the class with the dependency needs to create an instance of the dependent class. 
This creates tight coupling between the classes, making it difficult to modify the code, and makes it harder to test the code in isolation.

With Spring's @Autowired, the framework automatically injects the required dependencies into the dependent class, 
allowing for looser coupling and more manageable code.

For example, let's say we have a class UserService that requires a UserRepository to perform database operations. 
Instead of explicitly creating an instance of the UserRepository in the UserService class, we can annotate the UserRepository with @Autowired.

*/
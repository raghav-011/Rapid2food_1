package com.rapid2food.blog.payloads;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Setter


public class UserDTO {

	 private int id;
	 
	 @NotNull
	 private String name;
	 
	 @NotNull
	 private String email;
	 
	 @NotNull
	 private String password;
	 
	 @NotNull
	 private int registrationNo;
}

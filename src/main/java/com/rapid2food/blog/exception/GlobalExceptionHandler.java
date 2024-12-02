package com.rapid2food.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rapid2food.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse>resourceNotFoundException(ResourceNotFoundException ex)
	{
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
}



/*
Annotation ek special code hota hai jo programmers use karte hain apne code mein. 
Ye code aksar @ ke sath shuru hota hai, aur usse hum apne classes, methods aur 
variables ke baare mein kuch additional information provide karte hain.

Spring Boot mein @ControllerAdvice jaise annotations ka use hota hai, 
jo humein apne application ke liye ek global exception handler define karne mein madad karta hai. 
Ye exception handler web request ke processing mein koi problem aane par unhe handle karne mein madad karta hai. 
@ExceptionHandler annotation iska ek important hissa hai, jo specific types ke exceptions ke liye 
methods ko define karta hai jisse hum unhe customize kar sakte hain.

Mukhya roop se, annotations Spring Boot mein code ke metadata ke liye use kiye jaate hain aur humare 
code ko configure aur manage karne mein madad karte hain.
*/
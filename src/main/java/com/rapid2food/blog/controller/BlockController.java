package com.rapid2food.blog.controller;

import java.util.List;

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

import com.rapid2food.blog.payloads.ApiResponse;
import com.rapid2food.blog.payloads.CategoryDto;
import com.rapid2food.blog.services.CategoryService;

@RestController
@RequestMapping("/api/block")
public class BlockController 
{
	@Autowired 
	private CategoryService categoryservice;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto>createCategory(@RequestBody CategoryDto categories)
	{

		CategoryDto createBloc=this.categoryservice.createCategory(categories);
		return new ResponseEntity<CategoryDto>(createBloc,HttpStatus.CREATED);
	}
	
	
	//update
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto>updateCategory(@RequestBody CategoryDto CategoryDto,@PathVariable Integer catId)
	{
		CategoryDto updateBloc=this.categoryservice.updateCategory(CategoryDto,catId);
		return new ResponseEntity<CategoryDto>(updateBloc,HttpStatus.CREATED);
	}
	
	
	//delete
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId)
	{
		this.categoryservice.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Block is deleted successfully",true),HttpStatus.OK);
	}
	
	//get
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId)
	{
		CategoryDto categorydto=this.categoryservice.getCategory(catId);
		return new ResponseEntity<CategoryDto>(categorydto,HttpStatus.OK);
	}
	
	//getAll
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory()
	{
		List<CategoryDto> categorydto=this.categoryservice.getAllCategory();
		return ResponseEntity.ok(categorydto);
	}

}

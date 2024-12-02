package com.rapid2food.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rapid2food.blog.entities.Category;
import com.rapid2food.blog.exception.ResourceNotFoundException;
import com.rapid2food.blog.payloads.CategoryDto;
import com.rapid2food.blog.repositories.CategoryRepo;
import com.rapid2food.blog.services.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService  {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category cat=this.modelMapper.map(categoryDto,Category.class);
		Category addedblock=this.categoryRepo.save(cat);
		return this.modelMapper.map(addedblock, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		Category block=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category "," id ",categoryId));
		block.setBlockTitle( categoryDto.getBlockTitle());
		block.setBlockDesc(categoryDto.getBlockDesc());
		Category updateCat=this.categoryRepo.save(block);
		return this.modelMapper.map(updateCat,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category block=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category "," id ",categoryId));
		this.categoryRepo.delete(block);
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category block=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category "," id ",categoryId));
		  
		return this.modelMapper.map(block,CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category>categories=this.categoryRepo.findAll();
		List<CategoryDto>blockdata=categories.stream().map((cat)->this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList()); 
		return blockdata;
	}

}

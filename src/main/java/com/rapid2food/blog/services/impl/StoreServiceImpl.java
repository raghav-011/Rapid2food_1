package com.rapid2food.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapid2food.blog.entities.Category;
import com.rapid2food.blog.entities.Store;
import com.rapid2food.blog.entities.User;
import com.rapid2food.blog.exception.ResourceNotFoundException;
import com.rapid2food.blog.payloads.StoreDto;
import com.rapid2food.blog.repositories.CategoryRepo;
import com.rapid2food.blog.repositories.StoreRepo;
import com.rapid2food.blog.repositories.UserRepo;
import com.rapid2food.blog.services.StoreServices;


@Service
public class StoreServiceImpl implements StoreServices {

	@Autowired
	private StoreRepo storerepo; 
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	 
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public StoreDto CreateStore(StoreDto storedto,Integer userid,Integer categoryid) {
		User user=this.userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("User","User id",userid));
		Category category=this.categoryRepo.findById(categoryid).orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryid));
		Store store=this.modelMapper.map(storedto,Store.class); 
		store.setImage("default.png");
		store.setAddedDate(new Date());
		store.setUser(user);
		store.setCategory(category);
		Store newStore=this.storerepo.save(store);
		return this.modelMapper.map(newStore,StoreDto.class);
	}

	@Override
	public StoreDto UpdateStore(StoreDto storedto, Integer storeId) {
		// TODO Auto-generated method stub
		Store stor=this.storerepo.findById(storeId).orElseThrow(()->new ResourceNotFoundException("Store","Store Id",storeId));
		stor.setTitle(storedto.getTitle());
		stor.setImage(storedto.getImage());
		Store updatedResult=this.storerepo.save(stor);
		return this.modelMapper.map(updatedResult,StoreDto.class);
	}

	@Override
	public void DeleteStore(Integer storeid) {
		Store stor=this.storerepo.findById(storeid).orElseThrow(()->new ResourceNotFoundException("Store","Store Id",storeid));
		System.out.println("ndwqfio");
		this.storerepo.delete(stor);
		}

	@Override
	public List<StoreDto> getAllPost() {
		 List<Store> stores=this.storerepo.findAll();
		 List<StoreDto> storeItem= stores.stream().map((post)->this.modelMapper.map(post, StoreDto.class)).collect(Collectors.toList());
		return storeItem;
	}

	@Override
	public StoreDto getStoretById(Integer storeId)
	{
		Store store=this.storerepo.findById(storeId).orElseThrow(()->new ResourceNotFoundException("Store","Store Id ",storeId));  
		return this.modelMapper.map(store, StoreDto.class);
	}

	@Override
	public List<StoreDto> getStoreByCategory(Integer categoryId) {
		
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","category Id ",categoryId));
	     List<Store> stores=this.storerepo.findByCategory(cat);
		 List<StoreDto> storeitem=stores.stream().map((store)->this.modelMapper.map(store,StoreDto.class)).collect(Collectors.toList());
		 return storeitem;
	}

	@Override
	public List<StoreDto> getStoreByUser(Integer userId) {
		User usr=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User Id ",userId));
	     List<Store> usrposts=this.storerepo.findByUser(usr);
	     List<StoreDto> storeitem=usrposts.stream().map((usrpost)->this.modelMapper.map(usrpost,StoreDto.class)).collect(Collectors.toList());
         return storeitem;	
	}

	@Override
	public List<StoreDto> searchStores(String keyword) {
		// TODO Auto-generated method stub
		List<Store> store= this.storerepo.findByTitle(keyword);
		List<StoreDto> strdto= store.stream().map((str)->this.modelMapper.map(str, StoreDto.class)).collect(Collectors.toList());
		return strdto;
	}
}

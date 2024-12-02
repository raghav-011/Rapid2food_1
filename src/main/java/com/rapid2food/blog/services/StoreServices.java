 package com.rapid2food.blog.services;

import java.util.List;
import com.rapid2food.blog.payloads.StoreDto;

public interface StoreServices {
	
	// create
	StoreDto CreateStore(StoreDto storedto,Integer userid,Integer categoryid);
	
	//update
	
	StoreDto UpdateStore(StoreDto storedto,Integer storeId);
	
	//delete
	void DeleteStore(Integer storeId);
	
	
	//getall
	List<StoreDto> getAllPost();
	
	
	//get by id
	StoreDto getStoretById(Integer storeId);

	// get by category
	List<StoreDto>getStoreByCategory(Integer categoryId);
	
	
	// get by user
	List<StoreDto>getStoreByUser(Integer userId);
	
	
	// search by keyword
	List<StoreDto>searchStores(String keyword);
}

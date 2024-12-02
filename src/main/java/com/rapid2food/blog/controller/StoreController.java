package com.rapid2food.blog.controller;

//import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rapid2food.blog.payloads.ApiResponse;
import com.rapid2food.blog.payloads.StoreDto;
import com.rapid2food.blog.services.FileService;
import com.rapid2food.blog.services.StoreServices;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/")
public class StoreController {
	@Autowired
	private StoreServices storeServices;
	
	@Autowired
	private FileService fileservice;
	
	@Value("${project.image}")
	private String path;
	
	//create 
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@PostMapping("/user/{userid}/category/{categoryid}/stores")
     public ResponseEntity<StoreDto>createStore(
		 @RequestBody StoreDto storedto,
		 @PathVariable Integer userid ,
		 @PathVariable Integer categoryid)
     {
	 StoreDto  createStore=this.storeServices.CreateStore(storedto,userid,categoryid);
	 return new ResponseEntity<StoreDto>(createStore,HttpStatus.CREATED);
     }
	
	
	//get by user
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping("/user/{userid}/stores")
	public ResponseEntity<List<StoreDto>>getStoreByUser(
			@PathVariable Integer userid)
	{
		List<StoreDto> stores=this.storeServices.getStoreByUser(userid);
		return new ResponseEntity<List<StoreDto>>(stores,HttpStatus.OK);
	}
	
	//get by category
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping("/category/{categoryId}/stores")
	public ResponseEntity<List<StoreDto>>getStoreByCategory( @PathVariable Integer categoryId)	
	{
		List<StoreDto> stores=this.storeServices.getStoreByCategory(categoryId);
		return new ResponseEntity<List<StoreDto>>(stores,HttpStatus.OK);
	}
	
	//get all posts'
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping("/stores")
	public ResponseEntity<List<StoreDto>>getAllPost()
	{
		List<StoreDto> allstore=this.storeServices.getAllPost();
		return new ResponseEntity<List<StoreDto>>(allstore,HttpStatus.OK);
	}
	
	//get post by id
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping("/stores/{storeid}")
	public ResponseEntity<StoreDto>getStoreById(@PathVariable Integer storeid)
	{
		StoreDto store=this.storeServices.getStoretById(storeid); 
		return new ResponseEntity<StoreDto>(store,HttpStatus.OK);
	}
	
	
	//deletepost
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@DeleteMapping("/stores/{storesid}")
	public ApiResponse deleteStore(@PathVariable Integer storesid)
	{
		System.out.println("called");
		this.storeServices.DeleteStore(storesid);
		return new ApiResponse("Store is Successfull Deleted",true);
	}
	
	//updatePost
	@PutMapping("/stores/{storeid}")
	public ResponseEntity<StoreDto> updateStore(@RequestBody StoreDto storedto, @PathVariable Integer storeid)
	{
		StoreDto updateStore=this.storeServices.UpdateStore(storedto, storeid);
		return new ResponseEntity<StoreDto>(updateStore,HttpStatus.OK);	
	}
	
	// search
	@GetMapping("/stores/search/{keywords}") 
	public ResponseEntity<List<StoreDto>> searchStore( @PathVariable("keywords") String keywords)
	{
		List<StoreDto> result=this.storeServices.searchStores(keywords);
		return new ResponseEntity<List<StoreDto>>(result,HttpStatus.OK);
	}
	
	//post image upload
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@PostMapping("/stores/image/upload/{storeid}")
	public ResponseEntity<StoreDto>uploadStoreImage(@RequestParam("image") MultipartFile image , @PathVariable Integer storeid ) throws IOException
	{
		StoreDto storedto=this.storeServices.getStoretById(storeid);
		String filename1=this.fileservice.uploadImage(path, image);
		
		storedto.setImage(filename1);
		StoreDto updateStore=this.storeServices.UpdateStore(storedto, storeid);
		return new ResponseEntity<StoreDto>(updateStore , HttpStatus.OK);
	}
	
	//Method to serve the file
	@CrossOrigin(origins = "http://127.0.0.1:5173/")
	@GetMapping(value="/post/image/{imageName}",produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(
			@PathVariable("imageName") String imageName,
			HttpServletResponse response 
			) throws IOException{
		InputStream resource = this.fileservice.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource,response.getOutputStream());
	}
	
}



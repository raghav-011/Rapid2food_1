package com.rapid2food.blog.payloads;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class StoreDto {

	private Integer storeId;
	
	private String title;
	
	private String image;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDTO user;
}

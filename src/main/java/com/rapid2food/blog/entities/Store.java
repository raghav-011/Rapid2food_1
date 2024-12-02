package com.rapid2food.blog.entities;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="stores")
public class Store 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer storeId;
	@Column(name="Store Name")
	private String title;
	private String image;
	private Date addedDate;
	@ManyToOne
	@JoinColumn(name="Category_Id")
	private Category category;   //join columns
	
	@ManyToOne
	private User user;
}

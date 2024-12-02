package com.rapid2food.blog.entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity // We have to declare this class for entity by using @entity
@Table(name="Users") // also need @Table we can change the name as well  as we use @Table it's include the prebuild packages
@NoArgsConstructor
@Setter
@Getter

public class User {	
 @Id  // use to define the primary key
 @GeneratedValue(strategy=GenerationType.AUTO) // to generate id auto 
 private int id;
 @Column(name="Username")
 private String name;
 private String email;
 private String password;
 private int registrationNo;
 
 @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 private List<Store>posts=new ArrayList<>(); 
}

// we can change the column name by using @column(name="UserName",nullable=false,length=100  ) annotation 
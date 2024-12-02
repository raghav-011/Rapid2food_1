package com.rapid2food.blog.entities;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Block")
@NoArgsConstructor
@Getter
@Setter

public class Category
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer BlockId;

@Column(name="Block Name")
private String BlockTitle;

@Column(name="Location")
private String BlockDesc;

@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)  //join columns
private List<Store>posts=new ArrayList<>();

}
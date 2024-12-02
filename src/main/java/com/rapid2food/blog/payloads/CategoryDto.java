package com.rapid2food.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class CategoryDto {

	private Integer BlockId;

	private String BlockTitle;

	private String BlockDesc;
}

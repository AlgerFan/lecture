package com.algerfan.webflux2.domain;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document(collection = "user")
@Data
@Builder
public class User {

	@Id
	private String id;

	@NotBlank
	private String name;

	@Range(min=10, max=100)
	private int age;

}

package com.loiane.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class CourseDTO {
	
	private Long id;
	@NotBlank
	@NotNull
	@Length(min = 5, max = 100)
	private String name;
	@NotNull
	@Length(max = 10)
	@Pattern(regexp = "Back-end|Front-end")
	private String category;
	@NotNull
	@Length(max = 10)
	@Pattern(regexp = "Ativo|Inativo")
	private String status = "Ativo";

}

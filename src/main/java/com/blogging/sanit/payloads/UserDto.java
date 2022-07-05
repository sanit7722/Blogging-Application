package com.blogging.sanit.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {


	private int id;
	
	@NotBlank
	@Size(min=3, message="Username should contails at least 3 characters")
	private String name;
	
	@Email(message="Email address is not valid")
	private String email;
	
	@NotBlank
	@Size(min = 3, max = 10, message="Password must be within 3 to 10 characters")
	private String password;
	
	@NotBlank
	private String about;
}

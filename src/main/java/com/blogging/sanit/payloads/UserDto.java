package com.blogging.sanit.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {


	private int id;
	
	@NotEmpty
	@Size(min=3, message="Username should contails at least 3 characters")
	private String name;
	
	@Email(message="Email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message="Password must be within 3 to 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
}

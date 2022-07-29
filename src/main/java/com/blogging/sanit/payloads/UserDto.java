package com.blogging.sanit.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@NotBlank
	@Email(message="Email address is not valid")
	private String email;
	
	@NotBlank
	@Size(min = 3, max = 10, message="Password must be within 3 to 10 characters")
	private String password;
	
	@NotBlank
	private String about;
	
	private Set<RoleDto> roles=new HashSet<>();
	
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}
}

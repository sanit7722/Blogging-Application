package com.blogging.sanit.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.sanit.entities.User;
import com.blogging.sanit.exceptions.ResourceNotFoundException;
import com.blogging.sanit.payloads.UserDto;
import com.blogging.sanit.repositories.UserRepo;
import com.blogging.sanit.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user=this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());

		User updatedUser=this.userRepo.save(user);

		return this.userToDto(updatedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user =this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		List<UserDto> userDtos=users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
		
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User"," id",userId));
		this.userRepo.delete(user);
		
		

	}

	private User dtoToUser(UserDto userDto) {

		User user=this.modelMapper.map(userDto, User.class);
		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */

		return user;
	}

private UserDto userToDto(User user) {

		UserDto userdto=this.modelMapper.map(user, UserDto.class);
		/*
		 * userdto.setId(user.getId()); userdto.setName(user.getName());
		 * userdto.setEmail(user.getEmail()); userdto.setPassword(user.getPassword());
		 * userdto.setAbout(user.getAbout());
		 */

		return userdto;
	}


}

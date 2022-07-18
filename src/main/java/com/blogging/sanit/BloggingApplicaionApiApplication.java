package com.blogging.sanit;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;

import com.blogging.sanit.config.AppConstants;
import com.blogging.sanit.entities.Role;
import com.blogging.sanit.repositories.RoleRepo;


@SpringBootApplication
public class BloggingApplicaionApiApplication implements CommandLineRunner{

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BloggingApplicaionApiApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(this.passwordEncoder.encode("xyz"));
		
		try {
			
			Role roleAdmin=new Role();
			roleAdmin.setId(AppConstants.ADMIN_USER);
			roleAdmin.setName("ADMIN_USER");
			
			Role roleNormal=new Role();
			roleNormal.setId(AppConstants.NORMAL_USER);
			roleNormal.setName("NORMAL_USER");
			
		
			List<Role> roles = List.of(roleAdmin,roleNormal);
			List<Role> result = this.roleRepo.saveAll(roles);
			
			result.forEach(role->{
				System.out.println(role.getName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

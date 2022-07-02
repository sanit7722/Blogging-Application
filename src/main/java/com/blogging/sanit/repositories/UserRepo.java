package com.blogging.sanit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.sanit.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}

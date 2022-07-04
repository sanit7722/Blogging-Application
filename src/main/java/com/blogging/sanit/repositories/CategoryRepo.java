package com.blogging.sanit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.sanit.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}

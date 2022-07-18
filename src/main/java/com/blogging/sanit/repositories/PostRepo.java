package com.blogging.sanit.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.blogging.sanit.entities.Post;
import com.blogging.sanit.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	//List<Post> findByCategory(Category category);
	Page<Post> findByUserId(Integer userId, Pageable pageable );
	
	@Query("select p from Post p where p.category.id=:categoryId")
	Page<Post> searchByCategoryId(@Param("categoryId") Integer categoryId, Pageable pageable );
	
	List<Post> findByTitleContaining(String title);
	
	
}

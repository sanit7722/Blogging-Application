package com.blogging.sanit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.sanit.entities.Category;
import com.blogging.sanit.entities.Post;
import com.blogging.sanit.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}

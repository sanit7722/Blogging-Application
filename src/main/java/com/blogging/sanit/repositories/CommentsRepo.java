package com.blogging.sanit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.sanit.entities.Comment;

public interface CommentsRepo extends JpaRepository<Comment, Integer> {

}

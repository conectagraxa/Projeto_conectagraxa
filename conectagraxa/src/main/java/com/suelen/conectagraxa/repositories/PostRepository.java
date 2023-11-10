package com.suelen.conectagraxa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suelen.conectagraxa.model.Post;




@Repository
public interface PostRepository extends JpaRepository<Post, Integer> 
{

}

package com.angular.blogbackend.repo;

import com.angular.blogbackend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post , Long> {
}

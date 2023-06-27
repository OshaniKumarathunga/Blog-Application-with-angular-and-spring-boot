package com.angular.blogbackend.service;

import com.angular.blogbackend.dto.PostDto;
import com.angular.blogbackend.entity.Post;
import com.angular.blogbackend.exception.PostNotFoundException;
import com.angular.blogbackend.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;

    @Autowired
    private PostRepo postRepo;

    public void createPost(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User username = authService.getCurrentUser().orElseThrow(()->
                new IllegalArgumentException("No User logged in"));
        post.setUserName(username.getUsername());
        post.setCreatedOn(Instant.now());
        postRepo.save(post);
    }

    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUserName(post.getUserName());
        return postDto;
    }

    public PostDto readSinglePost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }
}

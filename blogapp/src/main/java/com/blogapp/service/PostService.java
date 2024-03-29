package com.blogapp.service;

import com.blogapp.entity.Post;
import com.blogapp.payload.ListPostDtos;
import com.blogapp.payload.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PostService {

    PostDto createPost(PostDto postDto);

  //  void deletePost(long id);

     List<Post> getPosts();

    public PostDto getPostById(long id);

    Optional<Post> existId(long id);

    void deletePost(long id);

    ListPostDtos fetchAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto updatePost(long id,PostDto postDto);

    Post deletePostById(long id);
}

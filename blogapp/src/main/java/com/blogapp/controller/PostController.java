package com.blogapp.controller;

import com.blogapp.entity.Post;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payload.ListPostDtos;
import com.blogapp.payload.PostDto;
import com.blogapp.service.PostService;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult )
    {
        if (bindingResult.hasErrors())
        {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.LENGTH_REQUIRED);
        }
        PostDto post = postService.createPost(postDto);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletePost(@PathVariable long id)
//    {
//        Optional<Post> post = postService.existId(id);
//        System.out.println(post);
//        if (post.isPresent()) {
//            postService.deletePost(id);
//            return new ResponseEntity<>("Record Is Deleted", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Record not found with id number : "+id,HttpStatus.NOT_FOUND);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deletePost(@PathVariable long id)
//    {
//        try
//        {
//            postService.deletePost(id);
//            return new ResponseEntity<>("Record Is Deleted",HttpStatus.OK);
//        }catch (ResourceNotFoundException e)
//        {
//            return new ResponseEntity<>("Resource Not Found With Id : "+id,HttpStatus.NOT_FOUND);
//        }
//    }

//    @GetMapping
//    public ResponseEntity<?> getPosts()
//    {
//        List<Post> posts = postService.getPosts();
//        return new ResponseEntity<>(posts,HttpStatus.OK);
//    }

    // Pagination
    // http://localhost:8080/api/posts?pageNo=&pageSize=5&sortBy="title"

    @GetMapping
    public ListPostDtos fetchAllPosts(
        @RequestParam(name="pageNo",defaultValue = "0",required=false)int pageNo,
        @RequestParam(name="pageSize",defaultValue = "5",required=false)int pageSize,
        @RequestParam(name="sortBy",defaultValue = "id",required=false)String sortBy,
        @RequestParam(name = "sortDir",defaultValue = "ASC",required = false)String sortDir)


    {
        ListPostDtos listPostDtos = postService.fetchAllPosts(pageNo, pageSize, sortBy, sortDir);
        return listPostDtos;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable long id,@RequestBody PostDto postDto)
    {
        PostDto dto = postService.updatePost(id, postDto);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable long id)
    {
        PostDto dto = postService.getPostById(id);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostByid(@PathVariable long id)
    {
        Post post = postService.deletePostById(id);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
}

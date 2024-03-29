package com.blogapp.controller;

import com.blogapp.payload.CommentDto;
import com.blogapp.payload.PostWithCommentDto;
import com.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    private CommentService commentService;

    @PostMapping("/{postId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable long postId)
    {
        CommentDto dto = commentService.createComment(commentDto, postId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity <PostWithCommentDto> getAllCommentsByPostId(@PathVariable long postId)
    {
        PostWithCommentDto allCommentsByPostId = commentService.getAllCommentsByPostId(postId);
        return  new ResponseEntity<>(allCommentsByPostId,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable long id)
    {
        commentService.deletById(id);
        return new ResponseEntity<>("Comment Is Deleted!!",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateComment(@PathVariable long id,@RequestBody CommentDto commentDto)
    {
        CommentDto dto = commentService.updateComment(id, commentDto);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }


}

package com.blogapp.service.impl;

import com.blogapp.entity.Comment;
import com.blogapp.entity.Post;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payload.CommentDto;
import com.blogapp.payload.PostWithCommentDto;
import com.blogapp.repository.CommentRepository;
import com.blogapp.repository.PostRepository;
import com.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper modelMapper;
    private PostRepository postRepository;
    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        Post post = byId.get();


        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

    public PostWithCommentDto getAllCommentsByPostId(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("There Is No Post With Id : "+id)
                );
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        List<CommentDto> dtos = comments.stream().map(c -> mapToDto(c)).collect(Collectors.toList());
        PostWithCommentDto pwcd = new PostWithCommentDto();
        pwcd.setCommentDtos(dtos);
        pwcd.setPost(post);
        return pwcd;
    }

    @Override
    public void deletById(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto) {
        Comment comment = commentRepository.findById(id).get();
        comment.setName(commentDto.getName());
        comment.setMessage(commentDto.getMessage());
        Comment save = commentRepository.save(comment);

       return mapToDto(save);
    }

    Comment mapToEntity(CommentDto dto)
    {
        Comment comment = modelMapper.map(dto, Comment.class);
        return comment;
    }

    CommentDto mapToDto(Comment comment)
    {
       return modelMapper.map(comment,CommentDto.class);
    }
}

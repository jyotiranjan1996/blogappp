package com.blogapp.service.impl;

import com.blogapp.entity.Post;
import com.blogapp.exception.ResourceNotFoundException;
import com.blogapp.payload.ListPostDtos;
import com.blogapp.payload.PostDto;
import com.blogapp.repository.PostRepository;
import com.blogapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

   private PostRepository postRepository;

   private ModelMapper modelMapper;



    public PostServiceImpl(PostRepository postRepository,ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post post = mapToEntity(postDto);

        Post savedPost = postRepository.save(post);

        PostDto dto = mapToDto(savedPost);

        return dto;
    }

    Post mapToEntity(PostDto postDto)
    {
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }

    PostDto mapToDto(Post post)
    {
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }





    @Override
    public void deletePost(long id) {
        postRepository.deleteById(id);
    }

    public PostDto getPostById(long id)
    {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Post Not Found With Id : "+id));
        return mapToDto(post);
    }



    @Override
    public List<Post> getPosts() {

        List<Post> all = postRepository.findAll();
        return all;
    }

    @Override
    public Optional<Post> existId(long id) {
        Optional<Post> byId = postRepository.findById(id);
        return byId;
    }

//    @Override
//    public void deletePost(long id) {
//        Optional<Post> byId = postRepository.findById(id);
//        if (byId.isPresent())
//        {
//            postRepository.deleteById(id);
//        }else
//        {
//            throw new ResourceNotFoundException("");
//        }
//
//    }

    @Override
    public ListPostDtos fetchAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

//        List<Post> post = postRepository.findAll();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> all = postRepository.findAll(pageable);
        List<Post> post = all.getContent();

        List<PostDto> postDtos = post.stream().map(p->mapToDto(p)).collect(Collectors.toList());
        ListPostDtos listPostDtos = new ListPostDtos();
        listPostDtos.setListPostDtos(postDtos);
        listPostDtos.setTotalPages(all.getTotalPages());
        listPostDtos.setTotalElements(all.getTotalElements());
        listPostDtos.setFirstPage(all.isFirst());
        listPostDtos.setLastPage(all.isLast());


        return listPostDtos;

    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepository.findById(id).get();

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());

        Post save = postRepository.save(post);
        PostDto dto = mapToDto(save);

        return dto;
    }

    @Override
    public Post deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Entered Id " + id + " Is An Invalid Id"));
        postRepository.deleteById(post.getId());
        return post;
    }


}

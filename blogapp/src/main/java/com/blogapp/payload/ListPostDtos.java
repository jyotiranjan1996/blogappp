package com.blogapp.payload;

import lombok.Data;

import java.util.List;

@Data
public class ListPostDtos {

    private List<PostDto> listPostDtos;
    private int totalPages;
    private long totalElements;
    private boolean firstPage;
    private boolean lastPage;
}

package com.blogapp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class ErrorDetails {

    private Date date;
    private String message;
    private String details;


}

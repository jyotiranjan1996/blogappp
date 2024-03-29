package com.blogapp.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private long id;

    @NotEmpty
    @Size(min = 3,message = "Title should be atleast 3 characters")
    private String title;

    @NotEmpty
    @Size(min = 3,message = "content should be atleast 3 characters")
    private String content;

    @NotEmpty
    @Size(min = 5,message = "Description should be atleast 5 characters")
    private String description;


//    @Email
//    private String email;
//    private String mobile;
}

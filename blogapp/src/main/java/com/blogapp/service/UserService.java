package com.blogapp.service;

import com.blogapp.payload.Signup;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Signup createUser(Signup signup);
}

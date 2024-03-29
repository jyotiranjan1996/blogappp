package com.blogapp.service.impl;

import com.blogapp.entity.User;
import com.blogapp.exception.EmailUsernameAlreadyExistException;
import com.blogapp.payload.Signup;
import com.blogapp.repository.UserRepository;
import com.blogapp.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    @Override
    public Signup createUser(Signup signup) {

            if (userRepository.existsByEmail(signup.getEmail())) {
                throw new EmailUsernameAlreadyExistException("This Email Id Is Already Registered");
            } else if (userRepository.existsByUsername(signup.getUsername())) {
                throw new EmailUsernameAlreadyExistException("This Username Is Already Registered");
            }

        User user = new User();
        user.setName(signup.getName());
        user.setUsername(signup.getUsername());
        user.setEmail(signup.getEmail());
        user.setPassword(passwordEncoder.encode(signup.getPassword()));

        User save = userRepository.save(user);

        return mapToDto(save);

//        User user = mapToEntity(signup);
//
//        User save = userRepository.save(user);
//        return mapToDto(save);


    }

    User mapToEntity(Signup signup)
    {
        return modelMapper.map(signup,User.class);
    }

    Signup mapToDto(User user)
    {
        return modelMapper.map(user,Signup.class);
    }
}

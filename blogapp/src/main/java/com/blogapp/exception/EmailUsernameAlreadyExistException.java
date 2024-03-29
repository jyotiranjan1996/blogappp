package com.blogapp.exception;



public class EmailUsernameAlreadyExistException extends RuntimeException{
    public EmailUsernameAlreadyExistException(String message)
    {
        super(message);
    }
}

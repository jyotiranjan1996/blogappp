package com.blogapp.exception;

import com.blogapp.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler({ResourceNotFoundException.class})
//    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex) {
//        return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
//    }
//}
        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException e, WebRequest webRequest)
        {
            ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(true));
            return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
        }
        @ExceptionHandler(EmailUsernameAlreadyExistException.class)
        public ResponseEntity<?> handleEmailAndUsernamealreadyExist(EmailUsernameAlreadyExistException e,WebRequest webRequest)
        {
            ErrorDetails error = new ErrorDetails(new Date(), e.getMessage(), webRequest.getDescription(true));
            return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }

}

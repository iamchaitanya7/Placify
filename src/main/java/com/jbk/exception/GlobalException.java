package com.jbk.exception;

import com.jbk.dto.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HashMap<String, String> invalidInput (MethodArgumentNotValidException exception) {
        HashMap<String, String> error = new HashMap<String, String> ( );
        List<FieldError> fieldErrors = exception.getFieldErrors ( );
        for (FieldError fieldError : fieldErrors) {
            error.put (fieldError.getField (), fieldError.getDefaultMessage ( ));
        }
        return error;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ExceptionResponse resourceNotFoundException (ResourceNotFoundException ex, HttpServletRequest request){
        ExceptionResponse response = new ExceptionResponse();
        response. setMessage(ex. getMessage ( ) ) ;
        response. setPath ( request. getRequestURI( ) ) ;
        response. setTimestamp (new Timestamp (System.currentTimeMillis ())) ;
        return response;
    }
}

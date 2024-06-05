package com.eazybytes.accounts.exception;

import com.eazybytes.accounts.dto.ErrorReponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorReponseDto> HandleCustomerAlreadyExistsException
            (CustomerAlreadyExistsException exception, WebRequest webRequest) {

        ErrorReponseDto errorReponseDto = new ErrorReponseDto(

                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorReponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorReponseDto> HandleNotFoundException
            (ResourceNotFoundException exception, WebRequest webRequest) {

        ErrorReponseDto errorReponseDto = new ErrorReponseDto(

                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(errorReponseDto,HttpStatus.BAD_REQUEST);
    }




}

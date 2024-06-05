package com.eazybytes.accounts.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ErrorReponseDto {


    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;

}

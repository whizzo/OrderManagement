package com.example.OrderManagement.System.HttpExceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class HttpRequestHandler extends RuntimeException{

    public HttpRequestHandler(String message){
        super(message);
    }


}

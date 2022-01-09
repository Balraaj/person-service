package com.forall.reacted.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NoPersonFoundException extends RuntimeException {
    public NoPersonFoundException(String message){
        super(message);
    }
}

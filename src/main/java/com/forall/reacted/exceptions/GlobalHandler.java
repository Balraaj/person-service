package com.forall.reacted.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalHandler {

    public ResponseEntity<ErrorResponse> handleException(Exception e){
        if(e instanceof NoPersonFoundException){
            return handleNoPersonFoundException((NoPersonFoundException) e);
        }
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "SERVER ERROR OCCURED"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> handleNoPersonFoundException(@NotNull NoPersonFoundException e){
        return new ResponseEntity<>(new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoPersonFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoPersonFoundException(Exception e){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
}

@Data
@AllArgsConstructor
class ErrorResponse{
    private Integer errorCode;
    private String message;
}

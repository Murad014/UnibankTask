package com.unibanktask.unibank.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class APIException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public APIException(HttpStatus status, String message){
        this.status = status;
        this.message = message;
    }


}

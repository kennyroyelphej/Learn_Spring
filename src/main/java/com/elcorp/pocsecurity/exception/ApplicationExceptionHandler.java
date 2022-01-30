package com.elcorp.pocsecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
@ResponseStatus
public class ApplicationExceptionHandler {

    @ExceptionHandler(InvalidArgumentsException.class)
    public ResponseEntity<Object> invalidArgumentException(InvalidArgumentsException e){
        ExceptionResponsePrototype exception = new ExceptionResponsePrototype(
                e.getMessage(),
//                e,
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exception,HttpStatus.BAD_REQUEST);
    }

}

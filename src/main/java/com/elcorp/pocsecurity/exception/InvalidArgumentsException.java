package com.elcorp.pocsecurity.exception;

public class InvalidArgumentsException extends Exception{
    public InvalidArgumentsException(String message) {
        super(message);
    }

    public InvalidArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentsException(Throwable cause) {
        super(cause);
    }

    public InvalidArgumentsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

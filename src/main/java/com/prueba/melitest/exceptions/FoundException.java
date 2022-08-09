package com.prueba.melitest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class FoundException extends RuntimeException {
    public FoundException(String message) {
        super(message);
    }
}

package com.prueba.melitest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception personalidad para lanzarce cuando exista una exce
 * @author Stiven Castro Arias
 * @since 08/08/2022
 * */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class FoundException extends RuntimeException {
    public FoundException(String message) {
        super(message);
    }
}

package com.controlevendedores.apirest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class RegistroNaoEncontradoException extends RuntimeException{
    public RegistroNaoEncontradoException(String message) {
        super(message);
    }
}

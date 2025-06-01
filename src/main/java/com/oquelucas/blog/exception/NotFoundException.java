package com.oquelucas.blog.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BlogException {

    public NotFoundException() {
        super("Objeto não encontrado", HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String msg) {
        super(msg, HttpStatus.NOT_FOUND, "NotFound");
    }
}

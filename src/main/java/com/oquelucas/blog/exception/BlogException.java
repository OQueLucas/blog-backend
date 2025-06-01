package com.oquelucas.blog.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BlogException extends RuntimeException {
    private final HttpStatus status;
    private final String error;

    public BlogException(String msg, HttpStatus status) {
        super(msg);
        this.status = status;
        this.error = "Erro interno";
    }

    public BlogException(String msg, HttpStatus status, String error) {
        super(msg);
        this.status = status;
        this.error = error;
    }
}

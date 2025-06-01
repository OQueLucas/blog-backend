package com.oquelucas.blog.controllers.exception;

import com.oquelucas.blog.exception.BlogException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(BlogException.class)
    public ResponseEntity<StandardError> treatBlogException(BlogException e, HttpServletRequest request) {
        StandardError err = new StandardError(System.currentTimeMillis(), e.getStatus().value(), e.getError(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(e.getStatus()).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<StandardError> treatException(Exception e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "UnknownError", e.getMessage(), request.getRequestURI());
        return ResponseEntity.internalServerError().body(err);
    }

}

package com.oquelucas.blog.controllers.exception;

public record StandardError(
        Long timestamp,
        Integer status,
        String error,
        String message,
        String path
) {}

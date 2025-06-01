package com.oquelucas.blog.dto;

import com.oquelucas.blog.domain.User;

public record AuthorDto(
        Long id,
        String name
) {
    public static AuthorDto from(User user) {
        return new AuthorDto(user.getId(), user.getName());
    }
}
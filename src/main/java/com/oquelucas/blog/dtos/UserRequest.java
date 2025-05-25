package com.oquelucas.blog.dtos;

import com.oquelucas.blog.domain.User;

public record UserRequest(String name, String email) {
    public User toUser() {
        return new User(null, name, email);
    }
}

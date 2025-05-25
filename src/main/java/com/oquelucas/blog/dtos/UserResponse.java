package com.oquelucas.blog.dtos;

import com.oquelucas.blog.domain.User;

public record UserResponse(String id, String name, String email) {
    public static UserResponse fromUser(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}

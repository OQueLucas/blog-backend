package com.oquelucas.blog.domain.post;

import com.oquelucas.blog.domain.User;
import lombok.Data;

@Data
public class Author {
    private String id;
    private String name;

    public Author() {
    }

    public Author(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }
}

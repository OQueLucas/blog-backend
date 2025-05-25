package com.oquelucas.blog.domain.post;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Data
public class Post {
    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private Author author;

    private List<Comment> comments = new ArrayList<>();

    public Post(String id, Date date, String title, String body, Author author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}

package com.oquelucas.blog.domain.post;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private Date date;
    private Author author;
}

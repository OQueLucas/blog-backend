package com.oquelucas.blog.usecase.post.search;

import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.dto.AuthorDto;

import java.time.OffsetDateTime;
import java.util.List;

public record SearchPostResponse(
        Long id,
        String title,
        String excerpt,
        String content,
        OffsetDateTime createdAt,
        AuthorDto author,
        List<String> categories,
        List<String> tags,
        int commentCount
) {
    public static SearchPostResponse from(Post post) {
        return new SearchPostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getExcerpt(),
                post.getCreatedAt(),
                AuthorDto.from(post.getAuthor()),
                post.getCategories(),
                post.getTags(),
                post.getComments() != null ? post.getComments().size() : 0
        );
    }
}
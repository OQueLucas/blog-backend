package com.oquelucas.blog.usecase.post.find;

import com.oquelucas.blog.domain.post.Category;
import com.oquelucas.blog.domain.post.Comment;
import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.domain.post.Tag;
import com.oquelucas.blog.dto.AuthorDto;

import java.time.OffsetDateTime;
import java.util.List;

public record FindPostByIdResponse(
        Long id,
        String title,
        String excerpt,
        String content,
        OffsetDateTime createdAt,
        AuthorDto author,
        List<String> categories,
        List<String> tags,
        List<CommentResponse> comments
) {
    public static FindPostByIdResponse from(Post post) {
        return new FindPostByIdResponse(
                post.getId(),
                post.getTitle(),
                post.getExcerpt(),
                post.getContent(),
                post.getCreatedAt(),
                AuthorDto.from(post.getAuthor()),
                List.copyOf(post.getCategories() != null ? post.getCategories().stream().map(Category::getName).toList() : List.of()),
                List.copyOf(post.getTags() != null ? post.getTags().stream().map(Tag::getName).toList() : List.of()),
                post.getComments().stream()
                        .map(CommentResponse::from)
                        .toList()
        );
    }

    public record CommentResponse(
            Long id,
            String text,
            OffsetDateTime createdAt,
            AuthorDto author,
            Long parentCommentId
    ) {
        public static CommentResponse from(Comment comment) {
            return new CommentResponse(
                    comment.getId(),
                    comment.getText(),
                    comment.getCreatedAt(),
                    AuthorDto.from(comment.getAuthor()),
                    comment.getParent() != null ? comment.getParent().getId() : null
            );
        }
    }
}

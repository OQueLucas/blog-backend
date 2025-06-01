package com.oquelucas.blog.controllers;

import com.oquelucas.blog.usecase.post.comment.add.AddCommentRequest;
import com.oquelucas.blog.usecase.post.find.FindPostByIdResponse;
import com.oquelucas.blog.usecase.post.search.SearchPostResponse;
import com.oquelucas.blog.usecase.post.comment.add.AddCommentUseCase;
import com.oquelucas.blog.usecase.post.search.SearchPostUseCase;
import com.oquelucas.blog.usecase.post.find.FindPostByIdUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final SearchPostUseCase searchPostUseCase;

    public PostController(SearchPostUseCase searchPostUseCase) {
        this.searchPostUseCase = searchPostUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SearchPostResponse>> findAll() {
        List<SearchPostResponse> list = searchPostUseCase.execute();
        return ResponseEntity.ok(list);
    }
}

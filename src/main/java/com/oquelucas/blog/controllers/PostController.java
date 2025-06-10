package com.oquelucas.blog.controllers;

import com.oquelucas.blog.usecase.post.find.FindPostByIdResponse;
import com.oquelucas.blog.usecase.post.find.FindPostByIdUseCase;
import com.oquelucas.blog.usecase.post.search.SearchPostResponse;
import com.oquelucas.blog.usecase.post.search.SearchPostUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private final SearchPostUseCase searchPostUseCase;
    private final FindPostByIdUseCase findPostByIdUseCase;

    public PostController(SearchPostUseCase searchPostUseCase,
                          FindPostByIdUseCase findPostByIdUseCase) {
        this.searchPostUseCase = searchPostUseCase;
        this.findPostByIdUseCase = findPostByIdUseCase;
    }

    @GetMapping
    public ResponseEntity<List<SearchPostResponse>> findAll() {
        List<SearchPostResponse> list = searchPostUseCase.execute();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<FindPostByIdResponse> findById(@PathVariable Long id) {
        FindPostByIdResponse post = findPostByIdUseCase.execute(id);
        return ResponseEntity.ok(post);
    }
}

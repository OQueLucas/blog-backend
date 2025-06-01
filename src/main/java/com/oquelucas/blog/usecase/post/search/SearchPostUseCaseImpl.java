package com.oquelucas.blog.usecase.post.search;

import com.oquelucas.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchPostUseCaseImpl implements SearchPostUseCase {

    @Autowired
    private PostRepository postRepository;

    public List<SearchPostResponse> execute() {
        return postRepository
                .findAll()
                .stream().map(SearchPostResponse::from)
                .toList();
    }
}

package com.oquelucas.blog.usecase.post.find;

import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.exception.NotFoundException;
import com.oquelucas.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPostByIdUseCaseImpl implements FindPostByIdUseCase {

    @Autowired
    private PostRepository postRepository;

    public FindPostByIdResponse execute(Long id) {
        Post post = postRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Post não encontrado"));

        return FindPostByIdResponse.from(post);
    }
}

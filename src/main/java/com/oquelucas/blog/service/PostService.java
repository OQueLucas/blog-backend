package com.oquelucas.blog.service;

import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.exception.NotFoundException;
import com.oquelucas.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> post = repo.findById(id);
        return post.orElseThrow(() -> new NotFoundException("Post não encontrado"));
    }
}

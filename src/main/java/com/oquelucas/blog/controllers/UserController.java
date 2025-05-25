package com.oquelucas.blog.controllers;

import com.oquelucas.blog.domain.User;
import com.oquelucas.blog.domain.post.Post;
import com.oquelucas.blog.dtos.UserRequest;
import com.oquelucas.blog.dtos.UserResponse;
import com.oquelucas.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<UserResponse> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(UserResponse.fromUser(user));
    }

    @PostMapping
    public ResponseEntity<UserResponse> insert(@RequestBody UserRequest userRequest) {
        User user = service.insert(userRequest);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id, @RequestBody UserRequest userRequest) {
        service.update(id, userRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value="/{id}/posts")
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user.getPosts());
    }
}

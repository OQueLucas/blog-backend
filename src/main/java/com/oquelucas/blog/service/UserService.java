package com.oquelucas.blog.service;

import com.oquelucas.blog.domain.User;
import com.oquelucas.blog.dtos.UserRequest;
import com.oquelucas.blog.dtos.UserResponse;
import com.oquelucas.blog.exception.NotFoundException;
import com.oquelucas.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<UserResponse> findAll() {
        return repo.findAll().stream().map(UserResponse::fromUser).toList();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    public User insert(UserRequest user) {
        return repo.insert(user.toUser());
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public void update(String id, UserRequest request) {
        User user = findById(id);
        updateData(user, request);
        repo.save(user);
    }

    private void updateData(User user, UserRequest request) {
        user.setName(request.name());
        user.setEmail(request.email());
    }
}

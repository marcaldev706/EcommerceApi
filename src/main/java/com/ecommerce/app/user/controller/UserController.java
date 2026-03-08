package com.ecommerce.app.user.controller;

import com.ecommerce.app.user.entity.UserEntity;
import com.ecommerce.app.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody UserEntity user) {
        UserEntity savedUser = userService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity newUser, @PathVariable("id") Long id) {
        UserEntity updatedUser = userService.update(newUser, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable("id") Long id) {
        UserEntity userById = userService.findById(id);

        return ResponseEntity.ok(userById);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> allUsers = userService.findAll();

        return ResponseEntity.ok(allUsers);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId){

        userService.delete(userId);

        return ResponseEntity.noContent().build();
    }
}

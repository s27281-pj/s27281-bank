package com.example.s27281_bank.controller;

import com.example.s27281_bank.model.User;
import com.example.s27281_bank.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByPathVariable(@PathVariable Integer id) {
        User user= userService.getById(id);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUserAccount(@RequestBody User user) {
        User createdUserAccount = userService.createUser(user);

        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body(createdUserAccount);
    }

}

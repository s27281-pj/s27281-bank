package com.example.s27281_bank.service;


import com.example.s27281_bank.exception.UserNotFoundException;
import com.example.s27281_bank.exception.ValidationException;
import com.example.s27281_bank.model.User;
import com.example.s27281_bank.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        Map<String, String> validationErrors = new HashMap<>();
        if (user.getInitialBalance() <= 0) {
            validationErrors.put("initialBalance", "Must be more than 0");
        }
        if (user.getPeselNumber() == null || user.getPeselNumber().isBlank()) {
            validationErrors.put("peselNumber", "Cannot be blank");
        }

        if (!validationErrors.isEmpty()){
            throw new ValidationException(validationErrors);
        }

       userRepository.create(user);

       return user;
    }

    public User getById(Integer id){
        Optional<User> userAccount = userRepository.getById(id);


        return userAccount.orElseThrow(() ->  new UserNotFoundException("User with id: "+id + " does not exist"));
    }

}

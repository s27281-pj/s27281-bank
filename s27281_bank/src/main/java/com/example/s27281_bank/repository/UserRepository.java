package com.example.s27281_bank.repository;

import com.example.s27281_bank.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class UserRepository {
    List<User> userList = new ArrayList<>();

    public User create(User user) {
        user.setId(userList.size());
        userList.add(user);

        return user;
    }

    public Optional<User> getById(Integer id){
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

}

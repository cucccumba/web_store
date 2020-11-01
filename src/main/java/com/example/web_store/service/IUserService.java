package com.example.web_store.service;

import com.example.web_store.model.LogData;
import com.example.web_store.model.User;

import java.util.List;

public interface IUserService {
    User getUserById(Integer id);
    User save(User user);
    boolean saveUser(User user);
    void deleteById(Integer id);
    User createUser(LogData logData);
    List<User> getAllUsers();
}

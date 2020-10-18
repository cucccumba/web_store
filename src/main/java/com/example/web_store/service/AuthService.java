package com.example.web_store.service;

import com.example.web_store.CustomErrors;
import com.example.web_store.CustomException;
import com.example.web_store.model.LogData;
import com.example.web_store.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UsersDB usersDB;

    @Override
    public User authUser(LogData logData) throws CustomException {
        List<User> users = usersDB.getContent();
        for (User user : users) {
            if (user.getName().equals(logData.getUsername()) && user.getPassword().equals(logData.getPassword()))
                return user;
        }
        throw CustomErrors.WRONG_USERNAME_OR_PASSWORD.getException();
    }

    @Override
    public User createUser(LogData logData) throws CustomException {
        if (logData.getPassword().length() < 7)
            throw CustomErrors.SHORT_PASSWORD.getException();
        User user = new User();
        user.setName(logData.getUsername());
        user.setPassword(logData.getPassword());
        return usersDB.createObject(user);
    }
}

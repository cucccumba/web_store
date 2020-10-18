package com.example.web_store.service;

import com.example.web_store.CustomErrors;
import com.example.web_store.CustomException;
import com.example.web_store.model.LogData;
import com.example.web_store.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersDB implements DataBase<User>{
    private List<User> createdUsers = new ArrayList<>();

    @Override
    public List<User> getContent() {
        return createdUsers;
    }

    @Override
    public void setContent(List<User> dbContent) {
        this.createdUsers = dbContent;
    }

    @Override
    public User createObject(User user) throws CustomException {
        if (this.createdUsers.stream()
                .filter(i -> i.getName().equals(user.getName()))
                .findFirst()
                .orElse(null) == null) {
            user.setId(this.createdUsers.size() + 1);
            createdUsers.add(user);
            return user;
        }
        else
            throw CustomErrors.USERNAME_IS_ENGAGED.getException();
    }
    public Integer getSize() {
        return createdUsers.size();
    }
}

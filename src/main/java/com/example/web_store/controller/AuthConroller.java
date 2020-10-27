package com.example.web_store.controller;

import com.example.web_store.CustomErrors;
import com.example.web_store.CustomException;
import com.example.web_store.model.LogData;
import com.example.web_store.model.User;
import com.example.web_store.service.AuthService;
import com.example.web_store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthConroller {
    @Autowired
    private AuthService authService;
    @Autowired
    private IUserService userService;
    /*
    @PostMapping("/signin")
    @ResponseBody
    public String signInUser(@RequestBody LogData logData) {
        try {
            return authService.authUser(logData).toString();
        } catch (CustomException e) {
            return e.getDescription();
        }
    }
    */

    @PostMapping("/signup")
    @ResponseBody
    public String signUpUser(@RequestBody LogData logData) {
        try {
            User user = authService.createUser(logData);
            if (user == null)
                throw CustomErrors.CANNOT_CREATE_USER.getException();
            return user.toString();
        } catch (CustomException e) {
            return e.getDescription();
        }
    }
}

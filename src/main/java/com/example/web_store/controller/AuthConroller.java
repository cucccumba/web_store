package com.example.web_store.controller;

import com.example.web_store.CustomException;
import com.example.web_store.model.LogData;
import com.example.web_store.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthConroller {
    @Autowired
    private AuthService authService;

    @PostMapping("/signin")
    @ResponseBody
    public String signIpUser(@RequestBody LogData logData) {
        try {
            return authService.authUser(logData).toString();
        } catch (CustomException e) {
            return e.getDescription();
        }
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signUnUser(@RequestBody LogData logData) {
        try {
            return authService.createUser(logData).toString();
        } catch (CustomException e) {
            return e.getDescription();
        }
    }
}

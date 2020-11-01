package com.example.web_store.controller;

import com.example.web_store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminContoller {
    @Autowired
    private IUserService userService;

    @GetMapping("/admin")
    public String getAdmin() {
        return "/admin";
    }
}

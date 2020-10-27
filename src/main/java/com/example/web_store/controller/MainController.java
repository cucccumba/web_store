package com.example.web_store.controller;

import com.example.web_store.model.CreateGood;
import com.example.web_store.model.Good;
import com.example.web_store.model.LogData;
import com.example.web_store.model.User;
import com.example.web_store.service.IGoodService;
import com.example.web_store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodService goodService;

    @GetMapping("/count/users")
    @ResponseBody
    public String countUsers() {
        return String.valueOf(userService.getAllUsers().size());
    }

    @GetMapping("/count/goods")
    @ResponseBody
    public String countGoods() {
        return String.valueOf(goodService.getAllGoods().size());
    }

    @PostMapping("/create/user")
    @ResponseBody
    public String createUser(@RequestBody LogData logData) {
        User user = userService.createUser(logData);
        return Optional.ofNullable(user)
                .map(User::toString)
                .orElse("Can't create user");
    }

    @PostMapping("/create/good")
    @ResponseBody
    public String createGood(@RequestBody CreateGood createGood) {
        Good good = goodService.createGood(createGood);
        return Optional.ofNullable(good)
                .map(Good::toString)
                .orElse("Can't create good");
    }

    @GetMapping("/show/users")
    @ResponseBody
    public String getAllUsers() {

        return userService.getAllUsers().toString();
    }

    @GetMapping("/show/goods")
    @ResponseBody
    public String getAllGoods() {
        return goodService.getAllGoods().toString();
    }
}

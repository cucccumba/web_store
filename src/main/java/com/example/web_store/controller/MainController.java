package com.example.web_store.controller;

import com.example.web_store.model.CreateGood;
import com.example.web_store.model.Good;
import com.example.web_store.model.User;
import com.example.web_store.service.GoodsDB;
import com.example.web_store.service.UsersDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UsersDB usersDB;
    @Autowired
    private GoodsDB goodsDB;

    @GetMapping("/count/users")
    @ResponseBody
    public String countUsers(){
        return String.valueOf(usersDB.getSize());
    }

    @GetMapping("/count/goods")
    @ResponseBody
    public String countGoods(){
        return String.valueOf(goodsDB.getSize());
    }
/*
    @PostMapping("/create/user")
    @ResponseBody
    public String createUser(@RequestBody User user) {
        users.add(user);
        return user.toString();
    }*/

    @PostMapping("/create/good")
    @ResponseBody
    public String createGood(@RequestBody CreateGood createGood) {
        Good good = new Good();
        good.setName(createGood.getName());
        good.setPrice(createGood.getPrice());
        return goodsDB.createObject(good).toString();
    }

    @GetMapping("/show/users")
    @ResponseBody
    public String getAllUsers() {
        List<User> users = usersDB.getContent();
        return users.toString();
    }

    @GetMapping("/show/goods")
    @ResponseBody
    public String getAllGoods() {
        List<Good> goods = goodsDB.getContent();
        return goods.toString();
    }
}

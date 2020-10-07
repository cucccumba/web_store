package com.example.web_store.Controller;

import com.example.web_store.Model.Good;
import com.example.web_store.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    private List<User> users = new ArrayList<>();
    private List<Good> goods = new ArrayList<>();

    @GetMapping("/count/users")
    @ResponseBody
    public String countUsers(){
        return String.valueOf(users.size());
    }

    @GetMapping("/count/goods")
    @ResponseBody
    public String countGoods(){
        return String.valueOf(goods.size());
    }

    @PostMapping("/create/user")
    @ResponseBody
    public String createUser(@RequestBody User user) {
        users.add(user);
        return user.toString();
    }

    @PostMapping("/create/good")
    @ResponseBody
    public String createUser(@RequestBody Good good) {
        goods.add(good);
        return good.toString();
    }

    @GetMapping("/show/users")
    @ResponseBody
    public String getAllUsers() {
        return users.toString();
    }

    @GetMapping("/show/goods")
    @ResponseBody
    public String getAllGoods() {
        return goods.toString();
    }
}

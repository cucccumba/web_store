package com.example.web_store.controller;

import com.example.web_store.model.CreateGood;
import com.example.web_store.model.Good;
import com.example.web_store.model.LogData;
import com.example.web_store.model.User;
import com.example.web_store.service.IGoodService;
import com.example.web_store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IGoodService goodService;
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/login")
    public String getLogin(Model model, @AuthenticationPrincipal User authenticatedUser) {
        System.out.println(model.toString());
        if (Objects.nonNull(authenticatedUser)) {
            return "redirect:/user";
        }
        model.addAttribute("userForm", new User());
        return "login";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @PostMapping("/login")
    public String setLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("userForm") User user,
                           BindingResult result) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsernamePasswordAuthenticationToken authReq
                = new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword(), user.getAuthorities());
        Authentication auth = authenticationManager.authenticate(authReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        return "redirect:/user";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error";
    }

    @GetMapping("/")
    public String home1() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

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

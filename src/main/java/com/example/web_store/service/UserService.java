package com.example.web_store.service;

import com.example.web_store.model.LogData;
import com.example.web_store.model.Role;
import com.example.web_store.model.User;
import com.example.web_store.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements IUserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User save(User user) {
        User userFromDB = userRepository.findUserByName(user.getName());
        if (userFromDB == null)
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public boolean saveUser(User user) {
        User userFromDB = userRepository.findUserByName(user.getName());
        if (userFromDB != null) {
            return false;
        }
        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User createUser(LogData logData) {
        User user = new User();
        user.setName(logData.getUsername());
        user.setPassword(logData.getPassword());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userRepository.findUserByName(name);
        System.out.println("name = '" + name + "'");
        System.out.println("load = " + ((user == null) ? "null" : user.toString()));
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}

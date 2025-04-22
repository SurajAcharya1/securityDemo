package com.example.securityDemo.service;

import com.example.securityDemo.entity.User;

public interface UserService {
    public User findByUserName(String username);
    public User save(User user);
    public int add(int a, int b);
}

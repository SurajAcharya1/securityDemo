package com.example.securityDemo.readModel.service;

import com.example.securityDemo.readModel.document.UserRead;

public interface UserReadService {
    public UserRead findByUserName(String username);
    public UserRead save(UserRead userRead);
}

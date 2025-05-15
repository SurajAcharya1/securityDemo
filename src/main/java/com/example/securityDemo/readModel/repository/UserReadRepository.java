package com.example.securityDemo.readModel.repository;

import com.example.securityDemo.readModel.document.UserRead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserReadRepository extends MongoRepository<UserRead, String> {
    public UserRead findByUsername(String username);
}

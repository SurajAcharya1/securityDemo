package com.example.securityDemo.repository;

import com.example.securityDemo.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(name = "User.findByUserName")
    public Optional<User> findByUsername(String username);

    @Query(value = "select User from User where username = 'ram'")
    public User getUser(String username);

}

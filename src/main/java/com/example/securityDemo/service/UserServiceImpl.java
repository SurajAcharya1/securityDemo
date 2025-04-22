package com.example.securityDemo.service;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.entity.User;
import com.example.securityDemo.repository.UserRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional()
    public User findByUserName(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        Specification<User> equalsUsername = (root, query, cb) ->
                cb.equal(root.get("username").as(String.class), username);
        return userRepository.findAll(equalsUsername).stream().findFirst().orElse(null);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void getSomething() {
        User user = userRepository.findByUsername("ram").orElse(null);
    }

    public int add(int a, int b) {
        return a + b;
    }

}

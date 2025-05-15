package com.example.securityDemo.service;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.entity.Address;
import com.example.securityDemo.entity.User;
import com.example.securityDemo.readModel.document.AddressRead;
import com.example.securityDemo.readModel.document.UserRead;
import com.example.securityDemo.readModel.service.UserReadService;
import com.example.securityDemo.repository.UserRepository;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MockServiceB mockServiceB;
    private final UserReadService userReadService;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           MockServiceB mockServiceB,
                           UserReadService userReadService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mockServiceB = mockServiceB;
        this.userReadService = userReadService;
    }

    @Override
    @Transactional()
    public User findByUserName(String username) {
//        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));

        String city = "";
        String countryName = "";
        Specification<User> equalsUsername = (root, query, cb) ->
                cb.equal(root.get("username"), username);
        /*Specification<User> equalsUsername = (root, query, cb) -> {
            Join<User, Address> addressJoin = root.join("address", JoinType.INNER);
            Join<Address, Country> countryJoin = addressJoin.join("country", JoinType.INNER);
            Predicate predicateCity = cb.equal(root.get("address"), city);
            Predicate predicateCountry = cb.equal(addressJoin.get("countryName"), countryName);
            return cb.and(predicateCity, predicateCountry);
        };*/
        return userRepository.findAll(equalsUsername).stream().findFirst().orElse(null);
    }

    @Override
    @Transactional()
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        String s = mockServiceB.intermediate("asd");
        Address address = new Address();
        address.setProvince("Bagmati");
        address.setDistrict("Kathmandu");
        address.setMunicipality("Kathmandu");
        address.setTole("Kumarigal");

        user.setAddress(address);
        User savedUser =  userRepository.save(user);

        UserRead userRead = new UserRead();
        userRead.setUserDBId(savedUser.getId());
        userRead.setName(savedUser.getName());
        userRead.setPassword(savedUser.getPassword());
        userRead.setUsername(savedUser.getUsername());
        userRead.setEmail(savedUser.getEmail());
        userRead.setRoleType(savedUser.getRoleType());
        userRead.setGender(savedUser.getGender());

        AddressRead addressRead = new AddressRead();
        addressRead.setProvince(user.getAddress().getProvince());
        addressRead.setDistrict(user.getAddress().getDistrict());
        addressRead.setMunicipality(user.getAddress().getMunicipality());
        addressRead.setTole(user.getAddress().getTole());
        addressRead.setAddressDBId(user.getAddress().getId());

        userRead.setAddressRead(addressRead);
        userReadService.save(userRead);

        return savedUser;
    }

    public void getSomething() {
        User user = userRepository.findByUsername("ram").orElse(null);
    }

    public int add(int a, int b) {
        return a + b;
    }

}

package com.example.securityDemo.readModel.service;

import com.example.securityDemo.readModel.document.AddressRead;
import com.example.securityDemo.readModel.document.UserRead;
import com.example.securityDemo.readModel.repository.UserReadRepository;
import org.springframework.stereotype.Service;

@Service
public class UserReadServiceImpl implements UserReadService {

    private final UserReadRepository userReadRepository;
    private final AddressReadService addressReadService;

    public UserReadServiceImpl(UserReadRepository userReadRepository,
                               AddressReadService addressReadService) {
        this.userReadRepository = userReadRepository;
        this.addressReadService = addressReadService;
    }

    @Override
    public UserRead findByUserName(String username) {
        return userReadRepository.findByUsername(username);
    }

    @Override
    public UserRead save(UserRead userRead) {
        AddressRead savedAddressRead = addressReadService.save(userRead.getAddressRead());
        userRead.setAddressRead(savedAddressRead);
        return userReadRepository.save(userRead);
    }
}

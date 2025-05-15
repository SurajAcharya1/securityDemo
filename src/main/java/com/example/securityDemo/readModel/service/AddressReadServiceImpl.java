package com.example.securityDemo.readModel.service;

import com.example.securityDemo.readModel.document.AddressRead;
import com.example.securityDemo.readModel.repository.AddressReadRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressReadServiceImpl implements AddressReadService {

    private final AddressReadRepository addressReadRepository;

    public AddressReadServiceImpl(AddressReadRepository addressReadRepository) {
        this.addressReadRepository = addressReadRepository;
    }

    @Override
    public AddressRead save(AddressRead addressRead) {
        return addressReadRepository.save(addressRead);
    }
}

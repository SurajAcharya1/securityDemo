package com.example.securityDemo.readModel.repository;

import com.example.securityDemo.readModel.document.AddressRead;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressReadRepository extends MongoRepository<AddressRead, String> {
}

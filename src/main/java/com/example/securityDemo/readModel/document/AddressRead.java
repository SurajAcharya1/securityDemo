package com.example.securityDemo.readModel.document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "address_read_model")
@Data
public class AddressRead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String province;
    private String district;
    private String municipality;
    private String tole;
    private Long addressDBId;
}

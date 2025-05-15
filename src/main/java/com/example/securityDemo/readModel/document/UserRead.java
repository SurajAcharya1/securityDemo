package com.example.securityDemo.readModel.document;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.entity.Address;
import com.example.securityDemo.enumerations.Gender;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "user_read_model")
@Data
public class UserRead {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private Long userDBId;

    private String name;

    private String password;

    private String username;

    private String email;

    private RoleType roleType;

    private Gender gender;

    private AddressRead addressRead;
}

package com.example.securityDemo.entity;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.enumerations.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "User.findByUserrName",
                query = "select u from User u where u.username = :userName"

        ),
        @NamedQuery(
                name = "User.findByEmail",
                query = "select u from User u where u.email = :email"
        )
})
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JsonIgnore
    private String password;

    private String username;

    private String email;

    private RoleType roleType;

    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}

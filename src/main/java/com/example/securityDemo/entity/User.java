package com.example.securityDemo.entity;

import com.example.securityDemo.RoleType;
import com.example.securityDemo.enumerations.Gender;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

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
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "role_type", nullable = false)
    private RoleType roleType;

    @Column(name = "gender", nullable = false)
    private Gender gender;
}

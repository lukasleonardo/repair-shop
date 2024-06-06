package com.car_repair_shop.domain.user;

import com.car_repair_shop.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType Role;

    public User(UserDTO userDTO) {
        this.login = userDTO.login();
        this.password = userDTO.password();
        this.Role = userDTO.role();
    }
}

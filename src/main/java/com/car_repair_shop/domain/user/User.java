package com.car_repair_shop.domain.user;


import com.car_repair_shop.dtos.userDTO.UserRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType Role;

    public User(UserRequestDTO userRequestDTO) {
        this.login = userRequestDTO.login();
        this.password = userRequestDTO.password();
        this.Role = userRequestDTO.role();
    }


}

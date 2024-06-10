package com.car_repair_shop.controller;

import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.dtoMappers.UserDTOMapper;
import com.car_repair_shop.dtos.userDTO.UserRequestDTO;
import com.car_repair_shop.dtos.userDTO.UserResponseDTO;
import com.car_repair_shop.exception.BadRequestException;
import com.car_repair_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequest) throws BadRequestException {
       if(userRequest == null)
           throw new BadRequestException("Requisição inválida ou ausente");

        User user = this.userService.createUser(userRequest);
        UserResponseDTO userResponse = UserDTOMapper.toDTO(user);

       return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable Long id){
        User user = this.userService.findUserById(id);
        UserResponseDTO userResponse = UserDTOMapper.toDTO(user);
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAllUsers(){
        List<UserResponseDTO> users = this.userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        this.userService.deleteUserById(id);
    }

}

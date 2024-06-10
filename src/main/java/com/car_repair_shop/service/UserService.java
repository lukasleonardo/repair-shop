package com.car_repair_shop.service;

import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.dtos.userDTO.UserRequestDTO;
import com.car_repair_shop.dtos.userDTO.UserResponseDTO;
import com.car_repair_shop.exception.NotFoundException;
import com.car_repair_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRequestDTO userRequestDTO){
        User user = new User(userRequestDTO);
        return this.userRepository.save(user);
    }

    public User findUserById(Long id) throws NotFoundException {
        return this.userRepository.findById(id).orElseThrow(()-> new NotFoundException("Usuário não encontrado com ID: "+id));
    }

    public List<UserResponseDTO> findAllUsers(){
        return this.userRepository.findAll().stream().map(UserResponseDTO::new).toList();
    }

    public void deleteUserById(Long id){
        this.userRepository.deleteById(id);
    }
}


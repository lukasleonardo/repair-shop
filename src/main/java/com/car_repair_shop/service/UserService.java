package com.car_repair_shop.service;

import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.dtos.userDTO.UserDTO;
import com.car_repair_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDTO userDTO){
        User user = new User(userDTO);
        this.userRepository.save(user);
        return user;
    }
    // EXEMPLO DE RETORNO CORRETO
    public UserDTO findUserById(Long id) throws Exception {
        User user = this.userRepository.findById(id).orElseThrow(()-> new Exception("Usuario não encontrado"));
        UserDTO userDto = new UserDTO(user);
        return userDto;
    }
    // EXEMPLO DE RETORNO CORRETO
    public List<UserDTO> findAllUsers(){
        List<UserDTO> users = this.userRepository.findAll().stream().map(UserDTO::new).toList();
        return users;
    }

    public void deleteUserById(Long id){
        this.userRepository.deleteById(id);
    }
}


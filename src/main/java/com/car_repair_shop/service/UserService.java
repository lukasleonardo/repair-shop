package com.car_repair_shop.service;

import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.dtos.UserDTO;
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
        return user;
    }

    public User findUserById(Long id) throws Exception {
        User user = this.userRepository.findById(id).orElseThrow(()-> new Exception("Usuario não encontrado"));
        return user;
    }

    public List<User> findAllUsers(){
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public void deleteUserById(Long id){
        this.userRepository.deleteById(id);
    }
}


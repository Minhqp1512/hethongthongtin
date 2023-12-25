package com.example.hethongthongtin.service.Impl;

import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.repository.UserRepository;
import com.example.hethongthongtin.service.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public void save(User user){
        userRepository.save(user);
    }
    public void remove(Long id){
        userRepository.deleteById(id);
    }

}

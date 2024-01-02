package com.example.hethongthongtin.service.impl;

import com.example.hethongthongtin.exception.UserNotFoundException;
import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.repository.UserRepository;
import com.example.hethongthongtin.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.StringBufferInputStream;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }
    @Override
    public String createUser(User user){
        userRepository.save(user);
        return "Success";
    }
    public String updateUser(User user){
        //xu ly logic o day
        userRepository.save(user);
        return "Success";
    }

    @Override
    public String deleteUser(String userID) {
        userRepository.deleteById(userID);
        return "Success";
    }

    @Override
    public User getUserById(String userID) {
        if(userRepository.findById(userID).isEmpty())
            throw new UserNotFoundException("khong ton tai nguoi dung co id: "+userID);
        return userRepository.findById(userID).get();
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getByName(String fullName) {
        if(userRepository.findByFull_name(fullName).isEmpty())
            throw new UserNotFoundException("khong ton tai nguoi dung co ten: "+fullName);
        return userRepository.findByFull_name(fullName);
    }

    @Override
    public List<User> getByAddress(String address) {
        if(userRepository.findByAddress(address).isEmpty())
            throw new UserNotFoundException("khong ton tai nguoi dung co dia chi : "+address);
        return userRepository.findByAddress(address);
    }

    @Override
    public List<User> getUserStartWithLetterH(String fullName) {
        if(userRepository.getUserStartWithLetterH(fullName).isEmpty())
        {
            throw new UserNotFoundException("Không tìm thấy người dùng có tên");
        }
        return userRepository.getUserStartWithLetterH(fullName) ;
    }

    @Override
    public List<User> getUserContainsLetterH(String fullName) {
        if(userRepository.getUserContainsLetterH(fullName).isEmpty())
        {
            throw new UserNotFoundException("Không tìm thấy người dùng có tên");
        }
        return userRepository.getUserContainsLetterH(fullName) ;
    }
    @Override
    public List<User> getUserIsNguyenVanAn(String fullName) {
        if(userRepository.getUserContainsLetterH(fullName).isEmpty())
        {
            throw new UserNotFoundException("Không tìm thấy người dùng có tên");
        }
        return userRepository.getUserContainsLetterH(fullName) ;
    }
}






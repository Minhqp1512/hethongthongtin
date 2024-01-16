package com.example.hethongthongtin.service.impl;

import com.example.hethongthongtin.exception.UserNotFoundException;
import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.repository.UserRepositoryJDBC;
import com.example.hethongthongtin.service.UserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    UserRepositoryJDBC userRepository;
    public UserServiceImpl(UserRepositoryJDBC userRepository){
        this.userRepository= userRepository;
    }
    @Override
    public String createUser(User user) throws SQLException {
        userRepository.addUser(user);
        return "Success";
    }
    public String updateUser(User user) throws SQLException {
        //xu ly logic o day
        userRepository.updateUser(user);
        return "Success";
    }

    @Override
    public String deleteUser(String userID) throws SQLException {
        userRepository.deleteUser(userID);
        return "Success";
    }

    @Override
    public User getUserById(String userID) throws SQLException {
        if(userRepository.findById(userID)==null)
            throw new UserNotFoundException("khong ton tai nguoi dung co id: "+userID);
        return userRepository.findById(userID);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUsers();
    }

    @Override
    public List<User> getByName(String fullName) throws SQLException {
        if(userRepository.findByName(fullName).isEmpty())
            throw new UserNotFoundException("khong ton tai nguoi dung co ten: "+fullName);
        return userRepository.findByName(fullName);
    }

    @Override
    public List<User> getByAddress(String address) throws SQLException {
        if(userRepository.findByAddress(address).isEmpty())
            throw new UserNotFoundException("khong ton tai nguoi dung co dia chi : "+address);
        return userRepository.findByAddress(address);
    }

    @Override
    public List<User> getUserStartWithLetterH() {
        if(userRepository.getUserStartWithLetterH().isEmpty())
        {
            throw new UserNotFoundException("Không tìm thấy người dùng có tên");
        }
        return userRepository.getUserStartWithLetterH() ;
    }
    @Override
    public List<User> getUserContainsLetterH() {
        if(userRepository.getUserContainsLetterH().isEmpty())
        {
            throw new UserNotFoundException("Không tìm thấy người dùng có tên");
        }
        return userRepository.getUserContainsLetterH() ;
    }
    @Override
    public User getUserIsNguyenVanAn() {
        if(userRepository.getUserIsNguyenVanAn()==null)
        {
            throw new UserNotFoundException("Không tìm thấy người dùng có tên");
        }
        return userRepository.getUserIsNguyenVanAn() ;
    }
    }








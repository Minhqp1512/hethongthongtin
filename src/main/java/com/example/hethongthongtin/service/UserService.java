package com.example.hethongthongtin.service;

import com.example.hethongthongtin.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    public String createUser(User user) throws SQLException;
    public String updateUser(User user) throws SQLException;
    public String deleteUser(String userID) throws SQLException;
    public User getUserById(String userID) throws SQLException;
    public List<User> getAllUser();
//    public List<User> getByName(String fullName);
//    public List<User> getByAddress(String address);
//    public List<User> getUserStartWithLetterH(String fullName);
//    public List<User> getUserContainsLetterH(String fullName);
//
//    public List<User> getUserIsNguyenVanAn(String fullName);


}

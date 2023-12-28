package com.example.hethongthongtin.service;

import com.example.hethongthongtin.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public String updateUser(User user);
    public String deleteUser(String userID);
    public User getUserById(String userID);
    public List<User> getAllUser();
    public List<User> getByName(String fullName);
    public List<User> getByAddress(String address);


}

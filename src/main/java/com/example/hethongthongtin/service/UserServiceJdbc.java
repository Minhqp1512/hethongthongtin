package com.example.hethongthongtin.service;

import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.repository.UserRepositoryJDBC;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceJdbc {
    private final UserRepositoryJDBC userRepositoryJDBC;

    public UserServiceJdbc(UserRepositoryJDBC userRepositoryJDBC) {
        this.userRepositoryJDBC = userRepositoryJDBC;
    }


    public void addUser(User user) throws SQLException{
        userRepositoryJDBC.addUser(user);
    }
    public void deleteUser(String userId) throws SQLException {
        userRepositoryJDBC.deleteUser(userId);
    }

    public User updateUser(User user) throws SQLException {
        userRepositoryJDBC.updateUser(user);
        return user;
    }

    public List<User> searchByName(String name) throws SQLException {
        return userRepositoryJDBC.searchByName(name);
    }

    public List<User> sortByName() throws SQLException {
        return userRepositoryJDBC.sortByName();
    }
    public List<User> findByName(String name) throws SQLException{
        return userRepositoryJDBC.findByName(name);
    }
    public  User findById(String userId) throws SQLException{
        return userRepositoryJDBC.findById(userId);
    }
    public List<User> findByAddress(String address) throws SQLException {
        return userRepositoryJDBC.findByAddress(address);
    }
    public List<User> getAllUsers() throws SQLException{
        return userRepositoryJDBC.getAllUsers();
    }
    public User getUserNguyenvana() throws SQLException{
        return userRepositoryJDBC.getUserIsNguyenVanAn();
    }
    public List<User> getUserStartLetterH(){
        return userRepositoryJDBC.getUserStartWithLetterH();
    }
    public List<User> getUserContainsLetterH(){
        return userRepositoryJDBC.getUserContainsLetterH();
    }
}

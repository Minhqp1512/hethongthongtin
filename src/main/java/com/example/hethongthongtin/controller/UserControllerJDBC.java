package com.example.hethongthongtin.controller;

import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.response.ResponseHandler;
import com.example.hethongthongtin.service.UserServiceJdbc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserControllerJDBC {
    public UserServiceJdbc userServiceJdbc;

    public UserControllerJDBC(UserServiceJdbc userServiceJdbc) {
        this.userServiceJdbc = userServiceJdbc;
    }
    @GetMapping("/hethongv2")
    public List<User> getAllUser() throws SQLException {
        return userServiceJdbc.getAllUsers();
    }


}

package com.example.hethongthongtin.controller;

import com.example.hethongthongtin.exception.UserException;
import com.example.hethongthongtin.exception.UserNotFoundException;
import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.repository.UserRepository;
import com.example.hethongthongtin.response.ResponseHandler;
import com.example.hethongthongtin.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //lấy toàn bộ user
    @GetMapping("/hethongthongtin")
    public List<User> getAllUserDetails()
    {
        return userService.getAllUser();

    }
    //lấy thông tin user dựa trên usid
    @GetMapping("/hethongthongtin/{user_id}")
    public ResponseEntity<Object> getUserByIdDetails(@PathVariable("user_id") String user_id)
    {
        return ResponseHandler.responseBuilder("User Infomation", HttpStatus.OK,userService.getUserById(user_id));
    }
    //lấy thông tin user dựa vào tên
    @GetMapping("/hethongthongtin/getname/{full_name}")
    public List<User> getUserByFullName(@PathVariable("full_name") String full_name ){
        return userService.getByName(full_name);
    }
    //lấy thông tin user dựa vào địa chỉ
    @GetMapping("/hethongthongtin/getaddress/{address}")
    public List<User> getUserByAddress(@PathVariable("address") String address ){
        return userService.getByAddress(address);
    }
    //tạo mới user
    @PostMapping("hethongthongtin")
    public String createUserDetails(  @RequestBody@Valid User user){
        userService.createUser(user);
        return "Tao moi user thanh cong";
    }
    //cập nhật user
    @PutMapping("hethongthongtin/{user_id}")
    public String updateUserDetails(  @RequestBody@Valid User user) {
        userService.updateUser(user);
        return "update user thanh cong";
    }
    //xóa user
    @DeleteMapping("hethongthongtin/{user_id}")
    public String deleteUserDetails(@PathVariable("user_id")String user_id){
        userService.deleteUser(user_id);
        return "xoa user thanh cong";
    }

    @GetMapping("hethongthongtin/find/{}")
    public List getUserStartWithLetterHDetails(String random){
        return userService.getUserStartWithLetterH(random);
    }
    @GetMapping("hethongthongtin/find/{}")
    public List getUserContainsLetterHDetails(String random){
        return userService.getUserContainsLetterH(random);
    }
    @GetMapping("hethongthongtin/find/{}")
    public List getUserIsNguyenVanAn(String random){
        return userService.getUserIsNguyenVanAn(random);
    }

}

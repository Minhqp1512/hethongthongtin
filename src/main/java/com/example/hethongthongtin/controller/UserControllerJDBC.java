package com.example.hethongthongtin.controller;

import com.example.hethongthongtin.model.User;
import com.example.hethongthongtin.response.ResponseHandler;
import com.example.hethongthongtin.service.UserServiceJdbc;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> getAllUser() throws SQLException {
        List<User> result= userServiceJdbc.getAllUsers();
        return ResponseHandler.responseBuilder(true,HttpStatus.OK,"Danh sách người dùng", result);
    }
    @PostMapping("/create")
    public String createUser(@Valid @RequestBody User user)throws SQLException{
        userServiceJdbc.addUser(user);
        return "Tao moi thanh cong";
    }
    @PutMapping("/update/{user_id}")
    public User updateUser(@PathVariable("user_id")int user_id, @Valid  @RequestBody User user ) throws SQLException{
         return userServiceJdbc.updateUser(user);
    }
    @DeleteMapping("delete/{user_id}")
    public String deleteUSer(@PathVariable("user_id") String user_id) throws SQLException{
        try{
            userServiceJdbc.deleteUser(user_id);
            return "xóa thành công";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/get/{address}")
    public ResponseEntity<Object> getUserByAddress(@PathVariable("address") String address) throws SQLException{
        try {
            List<User> result = (List<User>) userServiceJdbc.findByAddress(address);
            return ResponseHandler.responseBuilder(true, HttpStatus.OK, "Tìm kiếm thành công", result);
        } catch(Exception e){
            return ResponseHandler.responseBuilder(true,HttpStatus.NOT_FOUND,"Không tồn tại user có địa chỉ",null);
        }
    }
    @GetMapping("findbyname/{full_name}")
    public ResponseEntity<Object> getUserByName(@PathVariable("full_name") String name) throws SQLException{
        try {
            List<User> result = (List<User>) userServiceJdbc.findByName(name);
            return ResponseHandler.responseBuilder(true, HttpStatus.OK, "Tìm kiếm thành công", result);
        } catch(Exception e){
            return ResponseHandler.responseBuilder(true,HttpStatus.NOT_FOUND,"Không tồn tại user có tên",null);
        }
    }
    @GetMapping("/findbyid/{user_id}")
    ResponseEntity<Object> getUserById(@PathVariable("user_id") String userId) throws SQLException{

        try {
            User user = (User) userServiceJdbc.findById(userId);
            return ResponseHandler.responseBuilder(true, HttpStatus.OK, "Tìm kiếm thành công", user);
        } catch(Exception e){
            return ResponseHandler.responseBuilder(true,HttpStatus.NOT_FOUND,"Không tồn tại user",null);
        }
    }
    @GetMapping("findUserStartH")
    ResponseEntity<Object> getUserStartLetterH() throws SQLException{
        try {
            User user = (User) userServiceJdbc.getUserStartLetterH();
            return ResponseHandler.responseBuilder(true, HttpStatus.OK, "Tìm kiếm thành công", user);
        } catch(Exception e){
            return ResponseHandler.responseBuilder(true,HttpStatus.NOT_FOUND,"Không tồn tại user",null);
        }
    }
    @GetMapping("findUserContainsH")
    ResponseEntity<Object> getUserContainsLetterH() throws SQLException{
        try {
            User user = (User) userServiceJdbc.getUserContainsLetterH();
            return ResponseHandler.responseBuilder(true, HttpStatus.OK, "Tìm kiếm thành công", user);
        } catch(Exception e){
            return ResponseHandler.responseBuilder(true,HttpStatus.NOT_FOUND,"Không tồn tại user",null);
        }
    }
    @GetMapping("findUserA")
    ResponseEntity<Object> getUserA() throws SQLException{
        try {
            User user = (User) userServiceJdbc.getUserNguyenvana();
            return ResponseHandler.responseBuilder(true, HttpStatus.OK, "Tìm kiếm thành công", user);
        } catch(Exception e){
            return ResponseHandler.responseBuilder(true,HttpStatus.NOT_FOUND,"Không tồn tại user",null);
        }
    }


}

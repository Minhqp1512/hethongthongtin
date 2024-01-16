package com.example.hethongthongtin.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "hethongthongtin")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int user_id;
    @Column(name ="username",nullable = false, unique = true)
    private String username;
    @Column(name = "full_name")
    @NotEmpty(message = "Không được để trống tên")
    private String full_name;
    @Column(name = "address")
    @NotEmpty(message = "Không được để trống địa chỉ")
    private String address;
    @Column(name = "age")
    @Min(value = 1,message = "Tuổi phải lớn hơn hoặc bằng 1")
    @Max(value = 100,message = "Tuổi phải nhỏ hơn hoặc bằng 100")
    private int age;
    private String avartar;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

    public void setFullname(String s) {
    }
}

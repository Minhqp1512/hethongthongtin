package com.example.hethongthongtin.repository;

import com.example.hethongthongtin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

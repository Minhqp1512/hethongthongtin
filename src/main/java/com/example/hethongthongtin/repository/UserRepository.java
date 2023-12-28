package com.example.hethongthongtin.repository;

import com.example.hethongthongtin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

//    @Query(value ="SELECT * FROM tuktuk WHERE userFullName =:userFullName"   ,nativeQuery = true)
//    List<User> findUserByFullName(String userFullName);
//    @Query(value ="SELECT * FROM tuktuk WHERE userAddress =:userAddress"   ,nativeQuery = true)
//    List<User> findUserByUserAddress(String userAddress);
    @Query(value ="SELECT * FROM hethongthongtin WHERE user_id =:userUID"   ,nativeQuery = true)
    List<User> findUserByUserUID(String userUID);
    @Query(value ="SELECT * FROM hethongthongtin WHERE full_name =:full_name"   ,nativeQuery = true)
    List<User> findByFull_name(String full_name);
    @Query(value ="SELECT * FROM hethongthongtin WHERE username =:username"   ,nativeQuery = true)
    List<User> findByUsername(String username);
    @Query(value ="SELECT * FROM hethongthongtin WHERE address =:address"   ,nativeQuery = true)
    List<User> findByAddress(String address);
}

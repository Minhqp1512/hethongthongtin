package com.example.hethongthongtin.repository;

import com.example.hethongthongtin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query(value ="SELECT * FROM hethongthongtin WHERE user_id =:userUID"   ,nativeQuery = true)
    List<User> findUserByUserUID(String userUID);
    @Query(value ="SELECT * FROM hethongthongtin WHERE full_name =:full_name"   ,nativeQuery = true)
    List<User> findByFull_name(String full_name);
    @Query(value ="SELECT * FROM hethongthongtin WHERE username =:username"   ,nativeQuery = true)
    List<User> findByUsername(String username);
    @Query(value ="SELECT * FROM hethongthongtin WHERE address =:address"   ,nativeQuery = true)
    List<User> findByAddress(String address);
    @Query(value = "INSERT INTO 'hethongthongtin'(user_id,username,fullname,address, age, avatar) value('','minh','minhminh','hanoi','25','')",nativeQuery = true)
    public String createUser();
    @Query(value ="SELECT * FROM hethongthongtin WHERE full_name LIKE 'H%'"   ,nativeQuery = true)
    List<User> getUserStartWithLetterH(String full_name);
    @Query(value ="SELECT * FROM hethongthongtin WHERE full_name LIKE '%H%'"   ,nativeQuery = true)
    List<User> getUserContainsLetterH(String full_name);
    @Query(value ="SELECT * FROM hethongthongtin WHERE full_name ='Nguyen Van An'"   ,nativeQuery = true)
    List<User> getUserIsNguyenVanAn(String full_name);
//     List<User> findUserByFull_nameContaining(String keyword);

}

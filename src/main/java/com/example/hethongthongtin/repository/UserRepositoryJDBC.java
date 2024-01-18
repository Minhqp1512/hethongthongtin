package com.example.hethongthongtin.repository;

import com.example.hethongthongtin.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserRepositoryJDBC {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO hethongthongtin ( username,full_name, address, age,avartar) VALUES ( ?, ?, ?,?,?)";
        jdbcTemplate.update(sql,user.getUsername(), user.getFull_name(), user.getAddress(), user.getAge(), user.getAvartar());
    }

    public void deleteUser(String userId) throws SQLException {
        String sql = "DELETE FROM hethongthongtin WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE hethongthongtin SET username = ?,full_name= ?, address = ?, age = ?, avartar= ? WHERE user_id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getFull_name(), user.getAddress(), user.getAge(), user.getAvartar(),user.getUser_id());
    }

    public List<User> searchByName(String name) throws SQLException {
        String sql = "SELECT * FROM hethongthongtin WHERE full_name LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + name + "%"}, new UserRowMapper());
    }

    public List<User> sortByName() throws SQLException {
        String sql = "SELECT * FROM hethongthongtin ORDER BY full_name";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
    public List<User> findByName(String name) throws SQLException {
        String sql = "SELECT * FROM hethongthongtin WHERE full_name = ?";
        return jdbcTemplate.query(sql, new Object[]{name}, new UserRowMapper());
    }

    public User findById(String userId) throws SQLException {
        String sql = "SELECT * FROM hethongthongtin WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserRowMapper());
    }

    public List<User> findByAddress(String address) throws SQLException {
        String sql = "SELECT * FROM hethongthongtin WHERE address = ?";
        return jdbcTemplate.query(sql, new Object[]{address}, new UserRowMapper());
    }
    public List<User> getAllUsers(){
        String sql= "SELECT * FROM hethongthongtin";
        return jdbcTemplate.query(sql,new UserRowMapper());
    }
    public List<User> getUserStartWithLetterH(){
        String sql= "SELECT * FROM hethongthongtin WHERE full_name like 'H%'";
        return jdbcTemplate.query(sql,new UserRowMapper());
    }

    public List<User> getUserContainsLetterH() {
        String sql= "SELECT * FROM hethongthongtin WHERE full_name like '%H%'";
        return jdbcTemplate.query(sql,new UserRowMapper());
    }
    public User getUserIsNguyenVanAn(){
        String sql= "SELECT * FROM hethongthongtin WHERE full_name = 'nguyenvana'";
        return (User) jdbcTemplate.query(sql,new UserRowMapper());
    }

    private static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setUser_id(resultSet.getInt("user_id"));
            user.setUsername(resultSet.getString("username"));
            user.setFull_name(resultSet.getString("full_name"));
            user.setAddress(resultSet.getString("address"));
            user.setAge(resultSet.getInt("age"));
            user.setAvartar(resultSet.getString("avartar"));
            return user;
        }

    }
}

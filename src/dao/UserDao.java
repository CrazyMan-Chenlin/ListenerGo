package dao;

import model.User;

public interface UserDao {
     void insertUser(User user);
     int  updatePassword(User user);
     User queryUser(String username);
}

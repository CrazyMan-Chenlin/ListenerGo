package service;

import model.User;

public interface UserService {
    void insertUser(User user);
    int updatePassword(User user);
    User queryUser(String username);
}

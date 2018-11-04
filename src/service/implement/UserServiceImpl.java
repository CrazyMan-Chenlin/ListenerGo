package service.implement;

import dao.implement.UserDaoImpl;
import model.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void insertUser(User user) {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.insertUser(user);

    }

    @Override
    public int updatePassword(User user) {
        return 0;
    }

    @Override
    public User queryUser(String username) {
        UserDaoImpl userDao=new UserDaoImpl();
        User user = userDao.queryUser(username);
        return user;
    }
}

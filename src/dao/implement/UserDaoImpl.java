package dao.implement;

import dao.UserDao;
import model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.JdbcUtil;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(User user) {
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        String sql="insert into User(username,password) value(?,?)";
        try {
            qr.update(sql,new Object[]{user.getUsername(),user.getPassword()});
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }
    @Override
    public int updatePassword(User user) {
       return 0;
    }

    @Override
    public User queryUser(String username) {
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
        String sql="select * from user where username=?";
        try {
           User user = (User)qr.query(sql, new BeanHandler(User.class),new Object[]{username});
           return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}

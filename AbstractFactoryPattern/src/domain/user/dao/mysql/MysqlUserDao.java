package domain.user.dao.mysql;

import domain.user.User;
import domain.user.dao.UserDao;

public class MysqlUserDao implements UserDao {

    @Override
    public void insertUser(User user) {
        System.out.println("MysqlUserDao.insertUser");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("MysqlUserDao.updateUser");
    }

    @Override
    public void deleteUser(String id) {
        System.out.println("MysqlUserDao.deleteUser");
    }
}

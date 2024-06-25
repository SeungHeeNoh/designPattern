package domain.user.dao.oracle;

import domain.user.User;
import domain.user.dao.UserDao;

public class OracleUserDao implements UserDao {

    @Override
    public void insertUser(User user) {
        System.out.println("OracleUserDao.insertUser");
    }

    @Override
    public void updateUser(User user) {
        System.out.println("OracleUserDao.updateUser");
    }

    @Override
    public void deleteUser(String id) {
        System.out.println("OracleUserDao.deleteUser");
    }
}

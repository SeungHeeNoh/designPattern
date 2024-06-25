package domain.user.dao;

import domain.user.User;

public interface UserDao {

    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(String id);
}

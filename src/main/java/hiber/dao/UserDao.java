package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getUsers();

    User getUserById(Integer id);

    void deleteUser(Integer id);

    void updateUser(User user);

    User getUserByLogin(String login);
}

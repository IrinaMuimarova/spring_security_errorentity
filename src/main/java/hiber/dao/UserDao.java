package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    List<User> getUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserByLogin(String login);
}

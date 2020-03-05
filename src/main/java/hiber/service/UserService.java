package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

    void updateUser(User user);

    User getUserByLogin(String login);
}

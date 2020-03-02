package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    boolean addUser(User user);
    void deleteUser(long id);
    User getUserById(Long id);
    void updateUser(User user);
    User getUserByLogin(String login);
}

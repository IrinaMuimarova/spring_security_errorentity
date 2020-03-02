package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    boolean saveUser(User user);
    void deleteUser(Long id);
    User getUserById(Long id);
}

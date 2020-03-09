package hiber.service;

import hiber.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
    List<User> getAllUser();

    void saveUser(User user);

    void deleteUser(Integer id);

    User getUserById(Integer id);

    void updateUser(User user);

    User getUserByLogin(String login);

}

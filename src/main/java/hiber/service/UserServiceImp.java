package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImpl;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public boolean addUser(User user) {
        userDao.add(user);
        return true;
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userDao.getAll();
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }


}

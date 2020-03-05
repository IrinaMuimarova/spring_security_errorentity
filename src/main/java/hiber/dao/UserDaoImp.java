package hiber.dao;

import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    @Override
    public List<User> getUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Transactional
    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public User getUserByLogin(String login) {
        return (User) entityManager
                .createQuery("from User where login = ?")
                .setParameter(0, login)
                .getSingleResult();
    }
}

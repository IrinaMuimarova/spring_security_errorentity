package hiber.dao;

import hiber.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void saveUser(User user) {
            entityManager.persist(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getUsers() {
        return (List<User>) entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUserById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByLogin(String login) {
        return (User) entityManager
                .createQuery("from User where login = ?")
                .setParameter(0, login)
                .getSingleResult();
    }
}

package hiber.dao;

import hiber.model.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        return (List<Role>) entityManager.createQuery("from Role").getResultList();

    }

    @Override
    public Role getRoleById(Integer id) {
        return entityManager.find(Role.class, id);
    }
}

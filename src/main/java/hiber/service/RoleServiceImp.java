package hiber.service;

import hiber.dao.RoleDao;
import hiber.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleDao roleDao;


    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Role getRoleById(Integer id) {
        return roleDao.getRoleById(id);
    }
}

package hiber.dao;

import hiber.model.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getRoles();

    Role getRoleById(Integer id);
}

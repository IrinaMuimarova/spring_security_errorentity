package hiber.service;

import hiber.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    Role getRoleById(Integer id);
}

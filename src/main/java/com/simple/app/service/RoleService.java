package com.simple.app.service;

import com.simple.app.entity.Role;
import com.simple.app.form.RoleForm;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRole(Long roleId);
    Role getRoleByName(String roleName);

    Role saveRole(RoleForm roleForm);
    Role deleteRole(Long roleId);
}

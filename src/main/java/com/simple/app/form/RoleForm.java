package com.simple.app.form;

import com.simple.app.entity.Role;

public class RoleForm {
    public Long roleId;
    public String name;

    public RoleForm() {

    }

    public RoleForm(Role role) {
        roleId = role.getId();
        name = role.getName();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

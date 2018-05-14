package com.simple.app.service;

import com.simple.app.entity.Role;
import com.simple.app.form.RoleForm;
import com.simple.app.repository.RoleRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger LOG = LoggerFactory.getLogger(RoleService.class);
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream()
                .filter(role -> !role.getIsDeleted())
                .collect(Collectors.toList());
    }

    @Override
    public Role getRole(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow(RuntimeException::new);
    }

    @Override
    public Role getRoleByName(String roleName) {
        List<Role> roles = roleRepository.findByName(roleName);
        List<Role> activeRoles = roles.stream()
                .filter(role -> !role.getIsDeleted())
                .collect(Collectors.toList());
        if(activeRoles.isEmpty()){
            return null;
        } else {
            if(activeRoles.size() > 1) {
                LOG.warn("Role with name: " + roleName + " has more than 1 active entries.");
            }
            return activeRoles.get(0);
        }
    }

    @Override
    public Role saveRole(RoleForm roleForm) {
        if(Objects.nonNull(roleForm.getRoleId())){
            Role role = roleRepository.getOne(roleForm.getRoleId());
            role.setName(StringUtils.upperCase(roleForm.getName()));
            return roleRepository.save(role);
        } else {
            Role role = new Role();
            role.setName(StringUtils.upperCase(roleForm.getName()));
            return roleRepository.save(role);
        }

    }

    @Override
    public Role deleteRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(RuntimeException::new);
        role.setIsDeleted(true);
        return roleRepository.save(role);
    }
}

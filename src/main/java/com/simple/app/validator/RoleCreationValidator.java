package com.simple.app.validator;

import com.simple.app.entity.Role;
import com.simple.app.form.RoleForm;
import com.simple.app.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Objects;

@Component
public class RoleCreationValidator implements Validator {
    private final RoleService roleService;

    @Autowired
    public RoleCreationValidator(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {
        RoleForm form = (RoleForm) o;
        Role matchingRole = roleService.getRoleByName(StringUtils.upperCase(form.getName()));
        if(Objects.nonNull(matchingRole)){
            errors.rejectValue("name", "role.duplicate","Role name already exist.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "role.name.required", "Role must have a name.");
    }
}

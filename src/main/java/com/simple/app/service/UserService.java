package com.simple.app.service;

import com.simple.app.entity.User;
import com.simple.app.form.RegistrationForm;

public interface UserService {
    User registerUser(RegistrationForm registrationForm);
    User findByUsername(String username);
}
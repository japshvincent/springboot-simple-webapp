package com.simple.app.service;


public interface SecurityService {
    String findLoggedInUsername();
    void autoLogin(String username, String passwordHash);
}

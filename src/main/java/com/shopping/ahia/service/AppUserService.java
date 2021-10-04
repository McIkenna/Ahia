package com.shopping.ahia.service;

import com.shopping.ahia.models.userContent.AppUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface AppUserService {
    AppUser addUser(AppUser user) throws Exception;
    AppUser findById(String id);
    AppUser findByEmail(String email);
    void deleteUser(String id);
    List<AppUser> getUsers();
}

package com.shopping.ahia.serviceImpl;

import com.shopping.ahia.models.userContent.AppUser;
import com.shopping.ahia.repository.AppUserRepository;
import com.shopping.ahia.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserImplementation implements AppUserService {

    @Autowired
    AppUserRepository appUserRepository;
    @Override
    public AppUser addUser(AppUser user) throws Exception {
        try{
            return appUserRepository.save(user);

        }catch(Exception ex){
            throw new Exception("Something was not right");
        }
    }

    @Override
    public AppUser findById(String id) {
        return appUserRepository.findById(id);
    }

    @Override
    public AppUser findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public void deleteUser(String id) {
    appUserRepository.delete(findById(id));
    }

    @Override
    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }
}

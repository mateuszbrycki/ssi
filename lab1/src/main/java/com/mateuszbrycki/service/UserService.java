package com.mateuszbrycki.service;

import com.mateuszbrycki.model.User;
import com.mateuszbrycki.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Mateusz Brycki on 17.10.2016.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public void save(User user) { this.userRepository.save(user); }

    public Boolean isUsernameUsed(String username) {
        User user = this.userRepository.findOneByUsername(username);

        if(user != null) {
            return true;
        }

        return false;
    }

    public Boolean isMailUsed(String mail) {
        User user = this.userRepository.findOneByMail(mail);

        if(user != null) {
            return true;
        }

        return false;
    }
}

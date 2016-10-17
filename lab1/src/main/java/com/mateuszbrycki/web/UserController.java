package com.mateuszbrycki.web;

import com.mateuszbrycki.model.User;
import com.mateuszbrycki.response.MessageResponse;
import com.mateuszbrycki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mateusz Brycki on 17.10.2016.
 */
@RestController
@RequestMapping(path =  "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public List<User> listUsers() {
        return this.userService.findAll();
    }


    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public ResponseEntity<MessageResponse> register(@RequestBody User user) {

        user.setActive(false);

        Boolean isMailUsed = this.userService.isMailUsed(user.getMail());
        Boolean isUsernameUsed = this.userService.isUsernameUsed(user.getUsername());

        if(!isMailUsed && !isUsernameUsed) {
            this.userService.save(user);
            return new ResponseEntity<MessageResponse>(new MessageResponse("User successfully registered."), HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<MessageResponse>(new MessageResponse("Mail or username is in use."), HttpStatus.FORBIDDEN);

    }


}

package com.mateuszbrycki.web;

import com.mateuszbrycki.model.User;
import com.mateuszbrycki.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Mateusz Brycki on 17.10.2016.
 */
@Controller
@RequestMapping
public class MainController {

    @Autowired
    private UserService userService;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {

        List<User> users = userService.findAll();

        model.addAttribute("users", users );

        return "controller/main";
    }

}

package com.ktt.mip.project.user.controller;

import com.ktt.base.message.GenericMessage;
import com.ktt.base.service.LocaleAwareMessageService;
import com.ktt.mip.project.user.domain.Role;
import com.ktt.mip.project.user.domain.User;
import com.ktt.mip.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/project/user")
public class UserController {

    @Autowired
    private LocaleAwareMessageService messageService;

    @Autowired
    private UserService service;

    @RequestMapping("/message")
    public void message(GenericMessage message, String code) {
        Map<String, String> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", messageService.getMessage(code));
        message.setMessage("msg000001");

        //message.enableCustomeMessage();
        message.setData(map);
    }

    @RequestMapping("/user/send")
    public void message(GenericMessage message, User user) {

        user.addRole(new Role());


        service.sendMessage(message, user);
    }

    @RequestMapping(method = RequestMethod.GET)
    public void queryUser(GenericMessage message) {
        //service.queryUser(message);

    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(GenericMessage message, User user) {
        service.createUser(message, user);
    }

    @RequestMapping(value="/{userId}", method = RequestMethod.GET)
    public void detailUser(GenericMessage message, User user) {
        service.queryUser(message, user);
    }

    @RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(GenericMessage message, User user) {
        service.deleteUser(message, user);
    }
}

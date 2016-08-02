package com.ktt.mip.project.user.service;

import com.ktt.base.message.GenericMessage;
import com.ktt.mip.project.user.adapter.UserAdapter;
import com.ktt.mip.project.user.domain.Role;
import com.ktt.mip.project.user.domain.User;
import com.ktt.mip.project.user.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserAdapter userAdapter;

    public void sendMessage(GenericMessage message, User user) {
        try {
            user.addRole(new Role("ROLE_ADMIN"));
            user.addRole(new Role("ROLE_USER"));

            userAdapter.sendMessage(user);
            message.setOK();
        }catch (Exception e) {
            e.printStackTrace();
            message.setNG();
        }
    }

    public List<User> queryUsers(GenericMessage message, User user) {
        return userMapper.selectUsers(user);
    }

    public User queryUser(GenericMessage message, User user) {
        return userMapper.selectUser(user);
    }

    @Transactional
    public void createUser(GenericMessage message, User user) {

        logger.info("User ==> {}", user.toString());

        try {
            int count = userMapper.insertUser(user);
            if(count!=1) {
                message.setNG();
            }
        }catch (Exception e) {
            e.printStackTrace();
            message.setNG();
        }

    }


    @Transactional
    public void modifyUser(GenericMessage message, User user) {
        try {
            int count = userMapper.updateUser(user);
            if(count!=1) {
                message.setNG();
            }
        }catch (Exception e) {
            message.setNG();
        }
        logger.info("{} 하이요 ", "KT Telecop");
    }

    @Transactional
    public void deleteUser(GenericMessage message, User user) {
        try {
            int count = userMapper.deleteUser(user);
            if(count!=1) message.setNG();
        }catch (Exception e) {
            message.setNG();
        }
    }

}

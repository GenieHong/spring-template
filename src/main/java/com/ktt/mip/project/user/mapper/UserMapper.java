package com.ktt.mip.project.user.mapper;

import com.ktt.mip.project.user.domain.User;

import java.util.List;

public interface UserMapper {

    User selectUser(User user);

    List<User> selectUsers(User user);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(User user);

}

package com.ktt.mip.project.user.adapter;

import com.ktt.mip.project.user.domain.User;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;


@MessagingGateway
public interface UserAdapter {

    @Gateway(requestChannel = "upcase.input")
    void sendMessage(User user);

}

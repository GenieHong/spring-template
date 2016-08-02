package com.ktt.mip.project.user.domain;

import com.ktt.base.domain.PagingAwareDomain;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.Collection;


@Alias("User")
public class User extends PagingAwareDomain{

    private int seq;
    private String userId;
    private String username;
    private String phone;


    private Collection<Role> roles;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        if(this.roles == null) this.roles = new ArrayList<>();
        roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "seq=" + seq +
                ", userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

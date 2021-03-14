package com.majiang.community.Service;

import com.majiang.community.dto.GithubUser;
import com.majiang.community.mapper.UserMapper;
import com.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(GithubUser githubUser) {


    }

    public void createOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser == null) {
            user.setGmtCreat(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreat());
            userMapper.insert(user);
        }
        else{
            dbUser.setAvatar_url(user.getAvatar_url());
            dbUser.setGmtModified(System.currentTimeMillis());
            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            userMapper.updateUser(user);
        }
    }
}


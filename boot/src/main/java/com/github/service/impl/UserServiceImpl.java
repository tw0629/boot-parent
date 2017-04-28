package com.github.service.impl;

import com.github.bo.UserBo;
import com.github.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by chenqimiao on 2017/4/28.
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    @Override
    public UserBo getUserByName(String name) {
        UserBo userBo = new UserBo();
        userBo.setAge(22);
        userBo.setCity("杭州");
        userBo.setUsername("Bob");
        return userBo;
    }
}

package com.github.service;

import com.github.bo.UserBo;
import com.github.domain.UserDo;
import com.github.dto.BootDto;

/**
 * Created by chenqimiao on 2017/4/28.
 */
public interface UserService {
    /**
     * 根据名字查询用户
     *
     * @param name
     * @return
     */
    public UserBo getUserByName(String name);

    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    public BootDto getUserByUsername(String username);

    /**
     * 根据用户名更新用户
     *
     * @param user
     * @return
     */
    public BootDto updateUserByUsername(UserDo user);
}

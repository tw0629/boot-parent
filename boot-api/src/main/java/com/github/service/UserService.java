package com.github.service;

import com.github.bo.UserBo;
import com.github.dto.BootDto;

/**
 * Created by chenqimiao on 2017/4/28.
 */
public interface UserService {
    public UserBo getUserByName(String name);

    public BootDto getUserByUsername(String username);
}

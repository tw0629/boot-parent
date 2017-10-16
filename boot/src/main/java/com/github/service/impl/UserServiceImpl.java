package com.github.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.bo.UserBo;
import com.github.domain.UserDo;
import com.github.dto.BootDto;
import com.github.service.UserService;
import com.github.transaction.UserTransaction;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by chenqimiao on 2017/4/28.
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserTransaction userTransaction;
    @Override
    public UserBo getUserByName(String name) {
        UserBo userBo = new UserBo();
        userBo.setAge(22);
        userBo.setCity("杭州");
        userBo.setUsername("Bob");
        return userBo;
    }

    @Override
    @Cacheable(value = "getUserByUsername")
    public BootDto getUserByUsername(String username) {
        BootDto bootDto = new BootDto();
        try {
            UserDo userDo = userTransaction.queryUserByUsername(username);
            if(userDo != null) {
                bootDto.setSuccess(true);
                bootDto.setData(userDo);
            }else {
                bootDto.setSuccess(false);
                bootDto.setMsg("查无此人");
            }
            return bootDto;

        }catch (Exception e){
            e.printStackTrace();
            bootDto.setSuccess(false);
            bootDto.setMsg("服务器异常");
            return bootDto;
        }
    }


    @Override
    @CacheEvict(value = "getUserByUsername" ,allEntries = true)
    public BootDto updateUserByUsername(UserDo user) {
        BootDto bootDto = new BootDto();
        if(StringUtils.isEmpty(user.getUsername())){
            bootDto.setSuccess(false);
            bootDto.setMsg("用户名不能为空");
            return bootDto;
        }
        if(StringUtils.isEmpty(user.getCity()) && user.getAge() == null){
            bootDto.setSuccess(false);
            bootDto.setMsg("城市和年龄不能同时为空");
            return bootDto;
        }
        bootDto = userTransaction.updateUserByUsername(user);

        return bootDto;
    }

}

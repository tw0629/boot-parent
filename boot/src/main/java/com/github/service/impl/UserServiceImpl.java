package com.github.service.impl;

import com.github.bo.UserBo;
import com.github.domain.UserDo;
import com.github.dto.BootDto;
import com.github.service.UserService;
import com.github.transactionManage.UserTransaction;
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
}

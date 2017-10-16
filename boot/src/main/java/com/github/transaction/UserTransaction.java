package com.github.transaction;

import com.github.dao.UserMapper;
import com.github.domain.UserDo;
import com.github.dto.BootDto;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chenqimiao on 2017/5/2.
 */
@Component
@Transactional(rollbackFor = Exception.class)
public class UserTransaction {
    @Resource
    private UserMapper userMapper;

    public UserDo queryUserByUsername(String username){

        UserDo userDo = userMapper.selectUserByUsername(username);
        return userDo;

    }

    public BootDto updateUserByUsername(UserDo user) {
        BootDto bootDto = new BootDto();
        int effectiveCount = userMapper.updateUserByUsername(user);
        if(effectiveCount>0){
            bootDto.setSuccess(true);
            UserDo userDo = userMapper.selectUserByUsername(user.getUsername());
            bootDto.setData(userDo);
            return bootDto;
        }else {
            bootDto.setSuccess(false);
            return bootDto;
        }

    }
}

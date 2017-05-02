package com.github.transactionManage;

import com.github.dao.UserMapper;
import com.github.domain.UserDo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chenqimiao on 2017/5/2.
 */
@Component
@Transactional
public class UserTransaction {
    @Resource
    private UserMapper userMapper;

    public UserDo queryUserByUsername(String username){

        UserDo userDo = userMapper.selectUserByUsername(username);
        return userDo;

    }
}

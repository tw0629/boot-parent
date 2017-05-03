package com.github.dao;

import com.github.domain.UserDo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by chenqimiao on 2017/5/2.
 */
public interface UserMapper {
    UserDo selectUserByUsername(@Param("username") String username);

    int updateUserByUsername(UserDo user);
}

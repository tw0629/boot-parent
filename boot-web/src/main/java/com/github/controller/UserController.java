package com.github.controller;

import com.github.bo.UserBo;
import com.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by chenqimiao on 2017/4/28.
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired(required = false)
    private UserService userService;

    @RequestMapping("getUserByName")
    @ResponseBody
    public UserBo getUserByName(String name){
        UserBo userBo = userService.getUserByName(name);
        return userBo;
    }
}

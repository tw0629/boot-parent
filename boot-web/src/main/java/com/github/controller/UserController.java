package com.github.controller;

import com.github.bo.UserBo;
import com.github.domain.UserDo;
import com.github.dto.BootDto;
import com.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "getUserByUsername",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
    @ResponseBody
    public BootDto getUserByUsername(@RequestParam(value = "username",required = true) String username){
        BootDto bootDto = userService.getUserByUsername(username);
        return bootDto;
    }
}

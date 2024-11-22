package com.imooc.mall.controller;

import com.imooc.mall.model.pojo.User;
import com.imooc.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public User personalPage(){
        return userService.getUser();
    }
}

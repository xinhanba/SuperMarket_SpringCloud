package com.hyz.user.controller;

import com.hyz.user.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserClientController {

    @Resource
    private IUserService userService;

    @GetMapping(value = "/login")
    public String getUser(String id, String name) {
        String str = "id:" + id + ", name=" + name + ", 1";
        System.out.println(str);
        return str;
    }

}

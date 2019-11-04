package com.hyz.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserClientController {

    @GetMapping(value = "/getUser")
    public String getUser(String id, String name) {
        String str = "id:" + id + ", name=" + name + ", 2";
        System.out.println(str);
        return str;
    }

}

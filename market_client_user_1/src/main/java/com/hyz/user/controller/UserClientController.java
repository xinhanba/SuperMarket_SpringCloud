package com.hyz.user.controller;

import com.hyz.user.domain.entity.ConsumerUser;
import com.hyz.user.exception.ServiceException;
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

    @GetMapping(value = "/getUser")
    public ConsumerUser getUser(String email, String pwd) throws ServiceException {
        return userService.searchUser(email, pwd);
    }

}

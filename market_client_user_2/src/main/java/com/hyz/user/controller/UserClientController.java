package com.hyz.user.controller;

import com.hyz.market.domain.entity.ConsumerUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserClientController {

    @GetMapping(value = "/getUser")
    public ConsumerUser getUser(HttpServletRequest request) {

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String xab = request.getHeader("Cookie");

        String str = "email:" + email + ", pwd=" + pwd + ", Cookie=" + xab + ", 2";
        System.out.println(str);
        ConsumerUser consumerUser = new ConsumerUser();
        consumerUser.setF_user_email(email);
        return consumerUser;
    }

    @GetMapping(value = "/getUser2")
    public ConsumerUser getUser2(String email, String pwd) {
        String str = "email2:" + email + ", pwd2=" + pwd + ", 2";
        System.out.println(str);
        ConsumerUser consumerUser = new ConsumerUser();
        consumerUser.setF_user_email(email);
        return consumerUser;
    }

    @GetMapping(value = "/getConsumerUser")
    public ConsumerUser getUser(@RequestBody ConsumerUser consumerUser) {
        return consumerUser;
    }

}

package com.hyz.user.controller;

import com.hyz.market.domain.entity.ConsumerUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZuulController {

    @RequestMapping(value = "user/getUser1")
    public ConsumerUser getUser() {
        return null;
    }

}

package com.hyz.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(name = "ribbon")
    public String main() {
        System.out.println("1111111111111111111111111");

        String url = "http://eureka-client-user/user/getUser?id={id}&name={name}";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", "123");
        params.put("name", "hyz");

        return restTemplate.getForObject(url, String.class, params);
    }

}

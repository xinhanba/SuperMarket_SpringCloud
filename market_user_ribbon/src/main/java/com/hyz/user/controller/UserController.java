package com.hyz.user.controller;

import com.hyz.market.domain.entity.ConsumerUser;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(name = "ribbon")
    public String main() {

        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-user");

        System.out.println(serviceInstance.getServiceId() + ",----" + serviceInstance.getHost() + ",=====" + serviceInstance.getPort());

        String url = "http://EUREKA-CLIENT-USER/user/getUser?email={email}&pwd={pwd}";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", "517491659@qq.com");
        params.put("pwd", "123456");

        ConsumerUser consumerUser = restTemplate.getForObject(url, ConsumerUser.class, params);
        return consumerUser.getF_user_email() + ", " + consumerUser.getF_user_pwd();
    }

}

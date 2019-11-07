package com.hyz.user.service.impl;

import com.hyz.market.domain.entity.ConsumerUser;
import com.hyz.user.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements IUserService {

    @Resource
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallBack")
    @Override
    public ConsumerUser getUser(String email, String pwd) {

        String url = "http://eureka-client-user/user/getUser?email={email}&pwd={pwd}";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        params.put("pwd", pwd);

        return restTemplate.getForObject(url, ConsumerUser.class, params);
    }

    public ConsumerUser fallBack(String email, String pwd) {
        System.out.println("进入fallBack方法：" + email + ", " + pwd);
        ConsumerUser user = new ConsumerUser();
        user.setF_user_id("-1L");
        user.setF_user_email("错误信息");
        return user;
    }

}

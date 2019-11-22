package com.hyz.user;

import com.hyz.user.filter.TokenFilter;
import com.hyz.user.filter.UserEmailFilter;
import com.hyz.user.filter.UserPwdFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    @Bean
    public UserEmailFilter userEmailFilter() {
        return new UserEmailFilter();
    }

    @Bean
    public UserPwdFilter userPwdFilter() {
        return new UserPwdFilter();
    }

    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

}

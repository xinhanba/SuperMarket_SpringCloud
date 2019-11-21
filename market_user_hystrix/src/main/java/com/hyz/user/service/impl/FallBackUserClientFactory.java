package com.hyz.user.service.impl;

import com.hyz.market.domain.entity.ConsumerUser;
import com.hyz.user.service.IUserFeignService;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FallBackUserClientFactory implements FallbackFactory<IUserFeignService> {

    private static final Logger logger = LoggerFactory.getLogger(FallBackUserClientFactory.class);

    @Override
    public IUserFeignService create(final Throwable cause) {

        FallBackUserClientFactory.logger.info("sorry, fallback3. reason was: ", cause);

        return new IUserFeignService() {
            @Override
            public ConsumerUser getUser(String email, String pwd) {

                FallBackUserClientFactory.logger.info("sorry, fallback3. reason was: ", cause);

                System.out.println("进入fallBack3方法：" + email + ", " + pwd);
                ConsumerUser user = new ConsumerUser();
                user.setF_user_id("-1L");
                user.setF_user_email("错误信息~~~~3333");
                return user;
            }

            @Override
            public ConsumerUser getUser2(String email, String pwd) {
                FallBackUserClientFactory.logger.info("sorry, fallback4. reason was: ", cause);
                System.out.println("进入fallBack4方法：" + email + ", " + pwd);
                ConsumerUser user = new ConsumerUser();
                user.setF_user_id("-1L");
                user.setF_user_email("错误信息~~~~44444");
                return user;
            }
        };
    }

}

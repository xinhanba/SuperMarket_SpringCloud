package com.hyz.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class KafkaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaClientApplication.class, args);
    }

}

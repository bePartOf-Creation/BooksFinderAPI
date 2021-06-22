package com.lms.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Slf4j
@SpringBootApplication
public class LmsApplication{

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
            return builder.setConnectTimeout(Duration.ofMillis(3000))
                    .setReadTimeout(Duration.ofMillis(3000)).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(LmsApplication.class, args);
    }

}

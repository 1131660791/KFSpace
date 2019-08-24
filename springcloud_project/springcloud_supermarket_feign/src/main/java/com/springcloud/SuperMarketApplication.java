package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.springcloud.service") // 指定扫描路径
@SpringBootApplication
public class SuperMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuperMarketApplication.class,args);
    }
}

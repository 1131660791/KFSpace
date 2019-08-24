package com.springcloud.basehystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 基础项目 启动类 加入 熔断器
 */
@EnableHystrix // 开启熔断机制
@EnableEurekaClient
@SpringBootApplication
public class BaseHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseHystrixApplication.class,args);
    }

}

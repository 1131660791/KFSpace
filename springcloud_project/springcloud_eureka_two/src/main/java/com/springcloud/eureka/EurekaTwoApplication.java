package com.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka 服务 集群2
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaTwoApplication.class, args);
    }
}

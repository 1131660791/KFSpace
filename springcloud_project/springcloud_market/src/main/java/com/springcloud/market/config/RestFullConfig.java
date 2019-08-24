package com.springcloud.market.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestFullConfig {

    /**
     * @LoadBalanced
     *      表示这个RestTemplate开启负载均衡，在调用服务提供者的接口时， 可使用 服务名称 替代真实IP地址。
     *      服务名称 就是服务提供者在application.yml中 配置的spring.application.name 属性的值
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

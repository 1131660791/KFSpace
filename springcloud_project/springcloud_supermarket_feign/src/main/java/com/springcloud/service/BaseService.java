package com.springcloud.service;

import com.springcloud.service.fallback.BaseServiceFallBack;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 通过 Feign 调用 另一个服务的 数据
 *   fallback : Hystrix熔断机制 当此接口类 报错后 跳转到 BaseServiceFallBack 类 实现接口中处理
 */

@FeignClient(value = "base-server",fallback = BaseServiceFallBack.class)
public interface BaseService {

    @LoadBalanced // 加入 Ribbon 客户端 负载均衡
    @PostMapping(value = "getProduct")
    String getProduct();

}

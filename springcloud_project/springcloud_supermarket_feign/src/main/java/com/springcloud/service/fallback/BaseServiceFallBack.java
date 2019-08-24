package com.springcloud.service.fallback;

import com.springcloud.service.BaseService;
import org.springframework.stereotype.Component;

/**
 * Feign 熔断实现
 *   @Component 必须 加入 实列 注解 才能 注入到 spring 容器中
 */
@Component
public class BaseServiceFallBack implements BaseService {

    @Override
    public String getProduct() {
        return null;
    }
}

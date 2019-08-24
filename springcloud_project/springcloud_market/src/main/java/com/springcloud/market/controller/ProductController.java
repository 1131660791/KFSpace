package com.springcloud.market.controller;


import com.springcloud.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;

/**
 * <p>
 *  通过 Ribbon 调用
 * </p>
 *
 * @author hzw
 * @since 2019-07-12
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    // 需要调用服务注册到 Eureka 上
    private final String server = "http://base-server";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/testRibbon")
    public Product testRibbon() {
        Product p = restTemplate.getForObject(server + "/product/d", Product.class);
        return p;
    }

}


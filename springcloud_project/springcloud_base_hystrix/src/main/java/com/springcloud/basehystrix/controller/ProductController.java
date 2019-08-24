package com.springcloud.basehystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.basehystrix.entity.Product;
import com.springcloud.basehystrix.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author base
 * @since 2019-07-08
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource(name = "productService")
    private ProductService productService;

    // @HystrixCommand 当该方法 异常后 熔断器 自动调用 备用 方法 (fallbackMethod)
    @HystrixCommand(fallbackMethod = "hystrixHandle")
    @RequestMapping("/d")
    public Product d() throws  Exception{
        Product product = new Product();
        product.setPid(1L);
        Product sd =  productService.getById(product);
        if(sd == null){ // 异常后 进入 熔断方法
            throw new Exception("熔断器生效");
        }
        return sd;
    }

    public Product hystrixHandle(){
        Product product = new Product();
        product.setPid(1L);
        product.setProductName("熔断器生效");
        product.setDbSource("熔断器数据");
        return product;
    }







}


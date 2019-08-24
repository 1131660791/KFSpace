package com.springcloud.base.controller;


import com.springcloud.base.entity.Product;
import com.springcloud.base.service.ProductService;
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

    @RequestMapping("/d")
    public Product d() {
        Product s = new Product();
        s.setPid(1L);
        Product sd =  productService.getById(s);
        return sd;
    }







}


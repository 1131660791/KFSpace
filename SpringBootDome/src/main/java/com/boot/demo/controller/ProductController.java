package com.boot.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.demo.common.redis.RedisUtils;
import com.boot.demo.pojo.Product;
import com.boot.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author base
 * @since 2019-10-17
 */
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private RedisUtils redisUtils;

    /**
     * 获取动态参数
     */
    @Value("${par.test_url}")
    private String testUrl;

    @RequestMapping("test")
    public String test() {
        return testUrl;
    }

    /**
     * 分页查询
     *
     * @return
     */
    @RequestMapping(value = "findAllProduct")
    public IPage<Product> findAllProduct() {
        Product p = productService.getById(1L);
        Page page = new Page();
        page.setCurrent(1L);
        page.setSize(2L);
        IPage<Product> product = productService.findProduct(page);
        return product;
    }

    @RequestMapping(value = "testExpro")
    public void testExpro() throws Exception {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }

    @RequestMapping(value = "pushTemplate")
    public void pushTemplate() {
        log.error("redisUtils: " + redisUtils.get("key"));
        System.out.println(redisUtils.get("key"));
    }

}
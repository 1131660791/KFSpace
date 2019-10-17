package com.boot.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.demo.pojo.Product;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author base
 * @since 2019-10-17
 */
public interface ProductService extends IService<Product> {

    IPage<Product> findProduct(Page page);
}

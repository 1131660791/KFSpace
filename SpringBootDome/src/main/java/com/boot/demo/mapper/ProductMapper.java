package com.boot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boot.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author base
 * @since 2019-10-17
 */
@Repository("productMapper")
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 分页
     *
     * @param page
     * @return
     */
    IPage<Product> findProductPage(Page page, @Param("product") Product product);
}

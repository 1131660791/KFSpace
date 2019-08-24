package com.springcloud.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.base.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author base
 * @since 2019-07-08
 */
@Repository("productMapper")
public interface ProductMapper extends BaseMapper<Product> {

}

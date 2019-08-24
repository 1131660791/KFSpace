package com.springcloud.basehystrix.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springcloud.basehystrix.entity.Product;
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
@Mapper
@Repository("productMapper")
public interface ProductMapper extends BaseMapper<Product> {

}

package com.boot.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzw
 * @since 2019-10-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("xs")
public class Xs extends Model<Xs> {

    private static final long serialVersionUID=1L;

    private Integer id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

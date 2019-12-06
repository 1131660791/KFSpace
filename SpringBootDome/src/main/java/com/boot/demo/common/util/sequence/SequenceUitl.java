package com.boot.demo.common.util.sequence;

import com.boot.demo.common.util.number.NumberUtils;

/**
 * 生成序列号工具
 */
public class SequenceUitl {

    /**
     * 默认生成序号数量
     */
    private static final int DEFAULT_COUNT = 10;

    public long getSequence() {
        return GlobalSequenceGenerator.getInstance().generateSequenceId();
    }

    /**
     * 批量生成序列号 -  默认生成 10 个
     * @param count
     * @return
     */
    public long[] getSequences(Integer count) {
        count = NumberUtils.isPositive(count) ? count : DEFAULT_COUNT;
        long[] ids = GlobalSequenceGenerator.getInstance().generateSequenceIds(count);
        return ids;
    }
}

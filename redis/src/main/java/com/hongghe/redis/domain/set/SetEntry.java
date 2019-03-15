package com.hongghe.redis.domain.set;

import lombok.Data;

/**
 * Redis支持Value为集合，其逻辑类型为REDIS_SET，REDIS_SET有两种encoding方式： REDIS_ENCODING_INTSET 和 REDIS_ENCODING_HT（同上）
 * 集合的元素类型和数量决定了encoding方式，默认采用REDIS_ENCODING_INTSET ，当满足以下条件时，转换为REDIS_ENCODING_HT：
 * 1. 元素类型不是整数
 * 2. 元素个数超过配置的“set-max-intset-entries”（默认512）
 * REDIS_ENCODING_INTSET是一个有序数组，使用的数据结构如下：
 *
 * @author: hongghe @date: 2019-03-15 17:35
 */
@Data
public class SetEntry {
}

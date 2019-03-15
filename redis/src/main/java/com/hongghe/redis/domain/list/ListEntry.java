package com.hongghe.redis.domain.list;

import lombok.Data;

/**
 * Redis支持Value为一个列表，其逻辑类型为REDIS_SET，REDIS_SET有两种encoding方式，REDIS_ENCODING_ZIPLIST和REDIS_ENCODING_LINKEDLIST
 * REDIS_ENCODING_ZIPLIST同上
 * REDIS_ENCODING_LINKEDLIST是比较正统双端链接表的实现:
 *
 * 列表的默认编码格式为REDIS_ENCODING_ZIPLIST，当满足以下条件时，编码格式转换为REDIS_ENCODING_LINKEDLIST
 * 1,元素大小大于list-max-ziplist-value（默认64）
 * 2,元素个数大于 配置的list-max-ziplist-entries（默认512）
 *
 * @author: hongghe @date: 2019-03-15 17:34
 */
@Data
public class ListEntry {
}

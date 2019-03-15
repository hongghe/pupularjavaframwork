package com.hongghe.redis.domain.sort.set;

import lombok.Data;

/**
 * Redis支持Value为有序集合，其逻辑类型为REDIS_ZSET，REDIS_ZSET有两种encoding方式： REDIS_ENCODING_ZIPLIST（同上）和 REDIS_ENCODING_SKIPLIST
 * REDIS_ENCODING_SKIPLIST使用的数据结构如下，其同事：
 *
 * 由于有续集每一个元素包括：<member，score>两个属性，为了保证对member和score都有很好的查询性能，REDIS_ENCODING_SKIPLIST同时采用字典和有序集两种数据结构来保存数据元素。字典和有序集通过指针指向同一个数据节点来避免数据冗余。
 * 字典中使用member作为key，score作为value，从而保证在O(1)时间对member的查找
 * 跳跃表基于score做排序，从而保证在 O(logN) 时间内完成通过score对memer的查询
 * 有续集默认也是采用REDIS_ENCODING_ZIPLIST的实现，当满足以下条件时，转换为REDIS_ENCODING_SKIPLIST
 * 1. 数据元素个数超过配置的zset_max_ziplist_entries 的值（默认值为 128 ）
 * 2. 新添加元素的 member 的长度大于配置的 zset_max_ziplist_value 的值（默认值为 64 ）
 *
 * @author: hongghe @date: 2019-03-15 17:35
 */
@Data
public class SortSetEntry {
}

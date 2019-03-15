package com.hongghe.redis.domain;

/**
 * @author: hongghe @date: 2019-03-15 17:53
 */
/**
 * 针对同一种数据类型，Redis会根据元素类型/大小/个数采用不同的编码方式，不同的编码方式在内存使用效率/查询效率上差距巨大，在遇到内存问题时，可以尝试下修改相关参数：
 * hash-max-ziplist-entries 512
 * hash-max-ziplist-value 64
 * list-max-ziplist-entries 512
 * list-max-ziplist-value 64
 * set-max-intset-entries 512
 * zset-max-ziplist-entries 128
 * zset-max-ziplist-value 64
 */
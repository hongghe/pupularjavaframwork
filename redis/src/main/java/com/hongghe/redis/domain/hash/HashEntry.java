package com.hongghe.redis.domain.hash;

import lombok.Data;

/**
 * Redis支持Value为Hash表，其逻辑类型为REDIS_HASH，REDIS_HASH可以有两种encoding方式： REDIS_ENCODING_ZIPLIST 和 REDIS_ENCODING_HT
 * REDIS_ENCODING_HT即前文提到的字典的实现
 * REDIS_ENCODING_ZIPLIST即ZIPLIST，是一种双端列表，且通过特殊的格式定义，压缩内存适用，以时间换空间。ZIPLIST适合小数据量的读场景，不适合大数据量的多写/删除场景
 * Hash表默认的编码格式为REDIS_ENCODING_ZIPLIST，在收到来自用户的插入数据的命令时：
 * 1,调用hashTypeTryConversion函数检查键/值的长度大于 配置的hash_max_ziplist_value（默认64）
 * 2,调用hashTypeSet判断节点数量大于 配置的hash_max_ziplist_entries （默认512）
 * 以上任意条件满足则将Hash表的数据结构从REDIS_ENCODING_ZIPLIST转为REDIS_ENCODING_HT
 *
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author: hongghe @date: 2019-03-15 17:34
 */
@Data
public class HashEntry {
}

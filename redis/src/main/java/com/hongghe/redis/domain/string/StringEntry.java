package com.hongghe.redis.domain.string;

import lombok.Data;

/**
 * Redis的所有的key都采用字符串保存，另外，Redis也支持字符串类型的value。
 * 字符串类型即前文中看到的REDIS_STRING，其物理实现（enconding）可以为 REDIS_ENCODING_INT或REDIS_ENCODING_RAW 
 * REDIS_ENCODING_INT保存为long型，即redis会尝试将一个字符串转化为Long，可以转换的话，即保存为REDIS_ENCODING_INT
 * 否则，Redis会将REDIS_STRING保存为字符串类型，即REDIS_ENCODING_RAW
 * 字符串类型在redis中用sds封装，主要为了解决长度计算和追加效率的问题，其定义如下：
 *
 * @author: hongghe @date: 2019-03-15 17:49
 */
@Data
public class StringEntry {
}

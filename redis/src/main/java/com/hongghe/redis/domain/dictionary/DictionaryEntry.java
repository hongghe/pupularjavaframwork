package com.hongghe.redis.domain.dictionary;

import lombok.Data;

/**
 * 字典是Redis最基础的数据结构，一个字典即一个DB，Redis支持多DB
 * Redis字典采用Hash表实现，针对碰撞问题，其采用的方法为“链地址法”，即将多个哈希值相同的节点串连在一起， 从而解决冲突问题。
 * “链地址法”的问题在于当碰撞剧烈时，性能退化严重，例如：当有n个数据，m个槽位，如果m=1，则整个Hash表退化为链表，查询复杂度O(n)
 * 为了避免Hash碰撞攻击，Redis随机化了Hash表种子
 * Redis的方案是“双buffer”，正常流程使用一个buffer，当发现碰撞剧烈（判断依据为当前槽位数和Key数的对比），分配一个更大的buffer，然后逐步将数据从老的buffer迁移到新的buffer。
 *
 * @author: hongghe @date: 2019-03-15 17:32
 */
@Data
public class DictionaryEntry {
}

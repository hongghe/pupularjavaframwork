package com.hongghe.memcached.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: hongghe @date: 2019-01-16 15:38
 */
@Data
@Component
@ConfigurationProperties(prefix = "memcached")
public class SockIOPoolConfig {
    /** 服务地址 */
    private String[] servers;
    /** 权重 */
    private Integer[] weights;
    /** 初始化连接数 */
    private int initConn;
    /** 最小连接数 */
    private int minConn;
    /** 最大连接数 */
    private int maxConn;
    /** 睡眠时长 */
    private long maintSleep;
    private boolean nagle;
    private int socketTO;
}
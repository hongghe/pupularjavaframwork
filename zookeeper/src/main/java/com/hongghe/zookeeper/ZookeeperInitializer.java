package com.hongghe.zookeeper;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author: hongghe @date: 2019-01-12 14:40
 */
public class ZookeeperInitializer {

    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource)this.dataSource).setMetricsTrackerFactory(new PrometheusMetricsTrackerFactory());
        }
    }
}

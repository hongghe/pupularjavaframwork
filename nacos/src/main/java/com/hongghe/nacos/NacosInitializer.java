package com.hongghe.nacos;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author: hongghe @date: 2019-01-12 11:48
 */
public class NacosInitializer {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) this.dataSource).setMetricRegistry(new PrometheusMetricsTrackerFactory());
        }
    }
}

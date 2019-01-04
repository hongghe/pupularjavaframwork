package com.hongghe.mybatis;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author hongghe 2019/1/4
 */
public class MybatisInitializer {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource) this.dataSource).setMetricRegistry(new PrometheusMetricsTrackerFactory());
        }
    }
}

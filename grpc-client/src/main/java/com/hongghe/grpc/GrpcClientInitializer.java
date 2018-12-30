package com.hongghe.grpc;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author hongghe 2018/12/25
 */
public class GrpcClientInitializer {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource)this.dataSource).setMetricsTrackerFactory(new PrometheusMetricsTrackerFactory());
        }
    }

}

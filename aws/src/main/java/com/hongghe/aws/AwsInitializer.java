package com.hongghe.aws;

import com.google.gson.Gson;
import com.hongghe.aws.configuration.Person;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.metrics.prometheus.PrometheusMetricsTrackerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * @author: hongghe @date: 2019-01-25 14:21
 */
public class AwsInitializer {

    @Autowired
    private Person person;

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
        System.out.println(new Gson().toJson(person));
        if (dataSource instanceof HikariDataSource) {
            ((HikariDataSource)this.dataSource).setMetricsTrackerFactory(new PrometheusMetricsTrackerFactory());
        }
    }
}

package com.hongghe.elasticsearch.controller;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: hongghe @date: 2019-03-26 16:41
 */
@RestController
@RequestMapping(path = "/template")
public class BookControllerTemplate {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @GetMapping(value = "/all")
    public List<Map<String, Object>> searchAll() throws Exception {
        //这一步是最关键的
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder srb = client.prepareSearch("product").setTypes("book");
        SearchResponse sr = srb.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet(); // 查询所有
        SearchHits hits = sr.getHits();
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit hit : hits) {
            Map<String, Object> source = hit.getSourceAsMap();
            list.add(source);
            System.out.println(hit.getSourceAsString());
        }
        return list;
    }


}
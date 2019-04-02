package com.hongghe.elasticsearch.dao;

import com.hongghe.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: hongghe @date: 2019-03-26 16:45
 */
public interface BookDao extends ElasticsearchRepository<Book,String> {

    void delete(String id);

    Book findOne(String id);
}
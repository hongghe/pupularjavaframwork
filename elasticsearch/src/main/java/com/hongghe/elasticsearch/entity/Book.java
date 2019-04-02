package com.hongghe.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author: hongghe @date: 2019-03-26 16:44
 */
@Data
@Document(indexName = "product", type = "book")
public class Book {
    @Id
    String id;
    String name;
    String message;
    String type;
}
package com.hongghe.elasticsearch.domain.blog;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author: hongghe @date: 2019-01-11 18:04
 */
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {
    private static final long serialVersionUID = 1300024979963121362L;

}

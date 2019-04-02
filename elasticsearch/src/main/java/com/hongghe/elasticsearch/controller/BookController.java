package com.hongghe.elasticsearch.controller;

import com.hongghe.elasticsearch.dao.BookDao;
import com.hongghe.elasticsearch.entity.Book;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: hongghe @date: 2019-03-26 16:43
 */
@RestController
@RequestMapping("/book")
@EnableSwagger2
public class BookController {

    @Autowired
    private BookDao bookDao;

    /**
     * 1、查  id
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookDao.findOne(id);
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Book> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> searchResult = bookDao.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        List<Book> list = new ArrayList<Book>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * 4、增
     * @param book
     * @return
     */
    @PostMapping("/insert")
    public Book insertBook(Book book) {
        bookDao.save(book);
        return book;
    }

    /**
     * 5、删 id
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Book insertBook(@PathVariable String id) {
        Book book = bookDao.findOne(id);
        bookDao.delete(id);
        return book;
    }

    /**
     * 6、改
     * @param book
     * @return
     */
    @PutMapping("/update")
    public Book updateBook(Book book) {
        bookDao.save(book);
        return book;
    }

}
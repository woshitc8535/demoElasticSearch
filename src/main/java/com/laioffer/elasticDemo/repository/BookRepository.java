package com.laioffer.elasticDemo.repository;

import com.laioffer.elasticDemo.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findBookByName(String name);

    public List<Book> findBooksByNameIsLike(String name);

}

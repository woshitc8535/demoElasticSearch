package com.laioffer.elasticDemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



@Document(indexName = "test")
public class Book {
    @Id
    private Integer Id;
    private String author;
    private String name;


    public Book() {
    }

    public Book(Integer id, String author, String name) {
        Id = id;
        this.author = author;
        this.name = name;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

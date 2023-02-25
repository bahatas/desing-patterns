package com.task;


import org.springframework.context.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Configuration
public class BookSearch {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public RecommendationService recommendationService() {
        return new RecommendationService(new BookRepository());
    }
}


class RecommendationService {

    public BookRepository repository;

    public RecommendationService(BookRepository repository) {
        this.repository = repository;
    }


    public String recommendBook() {
        return repository.getBooks().get(0);
    }
}


class BookRepository {
    public List<String> getBooks() {
        List<String> books = new ArrayList<>();
        books.add("Book");
        books.add("Short book");
        books.add("Long book");

        return books;

    }

}



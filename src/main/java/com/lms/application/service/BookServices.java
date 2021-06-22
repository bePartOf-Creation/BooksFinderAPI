package com.lms.application.service;

import com.lms.application.data.models.Book;
import com.lms.application.data.models.SearchResult;

import java.util.List;

public interface BookServices {
    Book findBookById(String id);
    List<SearchResult> findAllBooks();
}

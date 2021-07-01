package com.lms.application.service;

import com.lms.application.data.models.Book;
import com.lms.application.data.models.SearchResult;
import com.lms.application.web.exceptions.BookNotFoundException;

import java.util.List;

public interface BookServices {
    Book findBookById(String id);
    List<Book> search(String keyword) throws BookNotFoundException;
}

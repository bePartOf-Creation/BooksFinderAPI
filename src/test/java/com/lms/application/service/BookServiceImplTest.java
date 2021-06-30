package com.lms.application.service;

import com.lms.application.data.models.Book;
import com.lms.application.data.models.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BookServiceImplTest {
    @Autowired
    BookServices bookServices;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findBookById() {
        Book book = bookServices.findBookById("KtrATnRZOlMC");
        assertThat(book).isNotNull();
        assertThat(book.getPublisher()).isEqualTo("C&T Publishing Inc");
        assertThat(book.getSubtitle()).isEqualTo("Everything First-Time Quilters Need to Succeed; 8 Quick Projects--Most in 4 Sizes");
    }

    @Test
    void search() {

            List<Book> books = bookServices.search("The Google Book");
            assertThat(books).isNotNull();
            assertThat(books).isNotEqualTo(0);
            for(Book book:books){
                log.info("Book searched has been seen --> {}", book);
            }

    }
}
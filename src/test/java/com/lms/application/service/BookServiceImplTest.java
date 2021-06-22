package com.lms.application.service;

import com.lms.application.data.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
    void findAllBooks() {
    }
}
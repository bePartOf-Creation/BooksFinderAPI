package com.lms.application.web.controller;

import com.lms.application.data.models.Book;
import com.lms.application.service.BookServices;

import com.lms.application.web.exceptions.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
@RequestMapping(path = "")
public class BookController {

    @Autowired
    private BookServices bookServices;

    private final String url = "https://www.googleapis.com/books/v1/volumes?q=quilting";

    @GetMapping(path = "/")
    public String getIndex(){
        return "index";
    }

    @GetMapping(path = "/search")
    public String searchBooks(Model model,@RequestParam("keyword") String keyword) {

        List<Book> bookList = null;
        try {
            bookList = bookServices.search(keyword);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
        }
        model.addAttribute("bookLists", bookList);
        return "allbooks";

    }
    @GetMapping(path = "/book/{id}")
    public String getABook(Model model, @PathVariable String id){
        Book aBook = bookServices.findBookById(id);
        model.addAttribute("books", aBook);
        return "allbooks";
    }



}

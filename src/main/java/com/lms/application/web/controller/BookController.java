package com.lms.application.web.controller;

import com.lms.application.data.models.Book;
import com.lms.application.service.BookServices;
import com.lms.application.web.exceptions.BookNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class BookController {

    @Autowired
    private BookServices bookServices;

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/search")
    public String searchBooks(Model model,@RequestParam("keyword") String keyword) {

        List<Book> bookList;
        try {
            bookList = bookServices.search(keyword);
            model.addAttribute("bookLists", bookList);
        } catch (BookNotFoundException e) {
           return "error";
        }

        return "allbooks";

    }
    @GetMapping(path = "/book/{id}")
    public String getABook(Model model, @PathVariable String id){
        Book aBook = bookServices.findBookById(id);
        model.addAttribute("books", aBook);
        return "allbooks";
    }



}

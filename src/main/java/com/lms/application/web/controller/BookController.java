package com.lms.application.web.controller;

import com.lms.application.data.models.SearchResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@Slf4j
public class BookController {

    @Autowired
    private RestTemplate restTemplate;

    private final String url = "https://www.googleapis.com/books/v1/volumes?q=quilting";

    @GetMapping(path = "/volumes")
    public SearchResult getABook(){
        SearchResult result = restTemplate.getForObject(url, SearchResult.class);
        log.info("Check Out SearchResult details  ---> {}",result);
        return result;
    }



}

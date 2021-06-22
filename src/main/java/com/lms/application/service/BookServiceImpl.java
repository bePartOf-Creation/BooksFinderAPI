package com.lms.application.service;

import com.lms.application.data.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookServiceImpl implements  BookServices {

     @Autowired
     private RestTemplate restTemplate;



    @Override
    public Book findBookById(String id) {
        String URI = "https://www.googleapis.com/books/v1/volumes/" + id;
        ResponseEntity<SearchResult> response = restTemplate.getForEntity(URI,SearchResult.class);
        SearchResult apiResponseResults = response.getBody();
        assert apiResponseResults != null;

        Book book = new Book();

        volumeInfo volumeInfo = apiResponseResults.getVolumeInfo();
        String title = volumeInfo.getTitle();
        String subtitle = volumeInfo.getSubtitle();
        List<String> author = volumeInfo.getAuthors();
        String publisher = volumeInfo.getPublisher();;
        String description = volumeInfo.getDescription();
        String previewLink = volumeInfo.getPreviewLink();
        imageLinks images = volumeInfo.getImageLinks();
        String smallThumbnail = images.getSmallThumbnail();
        String thumbnail = images.getThumbnail();

        book.setTitle(title);
        book.setSubtitle(subtitle);
        book.setPreviewLink(previewLink);
        book.setPublisher(publisher);
        book.setSmallThumbnail(smallThumbnail);
        book.setThumbnail(thumbnail);
        book.setAuthors(author);
        book.setDescription(description);

        return book;
    }

    @Override
    public List<SearchResult> findAllBooks() {
        return null;
    }
}

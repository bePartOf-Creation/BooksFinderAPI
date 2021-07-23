package com.lms.application.service;

import com.lms.application.data.models.*;
import com.lms.application.web.exceptions.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements  BookServices {

     @Autowired
     private RestTemplate restTemplate;


    @Override
    public Book findBookById(String id) {
        final String URI = "https://www.googleapis.com/books/v1/volumes/" + id; //
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
    public List<Book> search(String querySentence) throws BookNotFoundException {
            if(Objects.equals(querySentence, null))
                throw new BookNotFoundException("Book Not Found. Thanks");
            try {
                final String URI = "https://www.googleapis.com/books/v1/volumes?q=" + querySentence;
                ResponseEntity<ApiResponse> apiResponseResults = restTemplate.getForEntity(URI, ApiResponse.class);
                ApiResponse apiResponse = apiResponseResults.getBody();
                assert apiResponse != null;
                return apiResponse.getItems().stream().map(
                        results -> {
                            Book book = new Book();

                            String bookId = results.getId();
                            volumeInfo volumeInfo = results.getVolumeInfo();
                            String title = volumeInfo.getTitle();
                            String subtitle = volumeInfo.getSubtitle();
                            List<String> author = volumeInfo.getAuthors();
                            String publisher = volumeInfo.getPublisher();
                            String description = volumeInfo.getDescription();
                            String previewLink = volumeInfo.getPreviewLink();
                            imageLinks images = volumeInfo.getImageLinks();
                            String smallThumbnail = images.getSmallThumbnail();
                            String thumbnail = images.getThumbnail();

                            book.setId(bookId);
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
                ).collect(Collectors.toList());
            }
            catch(Exception exception){
                throw new BookNotFoundException();
            }

    }
}

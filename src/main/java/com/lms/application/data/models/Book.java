package com.lms.application.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String id;
    private String title;
    private String subtitle;
    private String publisher;
    private String previewLink;
    private String smallThumbnail;
    private String Thumbnail;
    private String description;
    private List<String> authors;
}
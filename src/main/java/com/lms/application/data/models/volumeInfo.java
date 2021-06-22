package com.lms.application.data.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class volumeInfo {
    private String title;
    private String subtitle;
    private String publisher;
    private String description;
    private Integer pageCount;
    private List<String> authors;
    private imageLinks imageLinks;
    private String previewLink;
}

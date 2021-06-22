package com.lms.application.data.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class imageLinks {
    private String smallThumbnail;
    private String thumbnail;
}

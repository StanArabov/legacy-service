package com.example.legacyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MovieDto {
    private String title;
    private String description;
    private Double rating;
    private LocalDateTime releaseDate;
    private Integer duration;
    private Integer year;
    private String director;
    private String writer;
    private String genres;
    private String stars;
    private String audio;
    private String subtitles;
}

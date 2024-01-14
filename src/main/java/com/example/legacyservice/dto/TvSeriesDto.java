package com.example.legacyservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class TvSeriesDto {
    private Integer metadataId;
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
    private List<SeasonDto> seasons;
//    private Integer type;
//    private Integer index;
//    private Integer parentId;
}

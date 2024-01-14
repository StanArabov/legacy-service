package com.example.legacyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SeasonDto {
    Integer metadataId;
    Integer number;
    List<EpisodeDto> episodes;
}

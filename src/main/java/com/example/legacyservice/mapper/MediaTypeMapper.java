package com.example.legacyservice.mapper;

import com.example.legacyservice.dto.EpisodeDto;
import com.example.legacyservice.dto.MovieDto;
import com.example.legacyservice.dto.SeasonDto;
import com.example.legacyservice.dto.TvSeriesDto;
import com.example.legacyservice.projection.MediaTypeProjection;
import com.example.legacyservice.projection.SeasonProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MediaTypeMapper {
    List<MovieDto> mediaTypeProjectionListToMovieDtoList(List<MediaTypeProjection> list);
    List<TvSeriesDto> mediaTypeProjectionListToTvSeriesDtoList(List<MediaTypeProjection> list);

    SeasonDto seasonProjectionToSeasonDto(SeasonProjection projection);
    List<SeasonDto> seasonProjectionListToSeasonDtoList(List<SeasonProjection> seasonProjectionList);

    EpisodeDto mediaTypeProjectionToEpisodeDto(MediaTypeProjection projection);

    List<EpisodeDto> mediaTypeProjectionListToEpisodeDtoList(List<MediaTypeProjection> list);

}

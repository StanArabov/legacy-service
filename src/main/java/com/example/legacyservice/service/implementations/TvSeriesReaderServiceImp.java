package com.example.legacyservice.service.implementations;

import com.example.legacyservice.dto.EpisodeDto;
import com.example.legacyservice.dto.SeasonDto;
import com.example.legacyservice.dto.TvSeriesDto;
import com.example.legacyservice.mapper.MediaTypeMapper;
import com.example.legacyservice.projection.MediaTypeProjection;
import com.example.legacyservice.projection.SeasonProjection;
import com.example.legacyservice.repository.MetadataItemsRepository;
import com.example.legacyservice.service.interfaces.TvSeriesReaderService;
import com.example.legacyservice.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
@AllArgsConstructor
public class TvSeriesReaderServiceImp implements TvSeriesReaderService {
    private final ExecutorService executorService;
    private final MetadataItemsRepository metadataItemsRepository;
    private final MediaTypeMapper mediaTypeMapper;

    @Override
    public CompletableFuture<List<TvSeriesDto>> readTvSeriesAsync(int pageNumber, int metadataType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                PageRequest pageable = PageRequest.of(pageNumber, Constants.TV_SERIES_PAGE_SIZE);
                return mediaTypeMapper.mediaTypeProjectionListToTvSeriesDtoList(
                        metadataItemsRepository.findSelectedMediaType(pageable, metadataType)
                );
            } catch (Exception e) {
                throw new RuntimeException("Error in read process", e);
            }
        }, executorService);
    }

    @Override
    public CompletableFuture<List<TvSeriesDto>> getTvSeriesSeasons(List<TvSeriesDto> tvSeriesDtoList) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Integer[] tvSeriesIds = tvSeriesDtoList.stream()
                        .map(TvSeriesDto::getMetadataId)
                        .toArray(Integer[]::new);
                List<SeasonProjection> seasonProjectionList = metadataItemsRepository.getTvSeriesSeasons(tvSeriesIds);
                tvSeriesDtoList.forEach(tvSeriesDto -> {
                    List<SeasonDto> tvSeriesSeason = seasonProjectionList.stream()
                            .filter(seasonDto -> Objects.equals(seasonDto.getParentId(), tvSeriesDto.getMetadataId()))
                            .map(mediaTypeMapper::seasonProjectionToSeasonDto)
                            .toList();

                    tvSeriesDto.setSeasons(tvSeriesSeason);
                });
                return tvSeriesDtoList;
            } catch (Exception e) {
                throw new RuntimeException("Error in read process", e);
            }
        }, executorService);
    }

    @Override
    public CompletableFuture<List<TvSeriesDto>> getTvSeriesSeasonsEpisodes(List<TvSeriesDto> tvSeriesDtoList) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Integer[] seasonIds = tvSeriesDtoList.stream()
                        .flatMap(tvSeriesDto -> tvSeriesDto.getSeasons().stream())
                        .map(SeasonDto::getMetadataId)
                        .toArray(Integer[]::new);

                List<MediaTypeProjection> episodeProjections = metadataItemsRepository.findSeasonEpisodes(seasonIds);
                tvSeriesDtoList.forEach(tvSeriesDto -> tvSeriesDto.getSeasons().forEach(seasonDto -> {
                    List<EpisodeDto> seasonEpisodes = episodeProjections.stream()
                            .filter(episode -> Objects.equals(episode.getParentId(), seasonDto.getMetadataId()))
                            .map(mediaTypeMapper::mediaTypeProjectionToEpisodeDto)
                            .toList();
                    seasonDto.setEpisodes(seasonEpisodes);
                }));
                return tvSeriesDtoList;
            } catch (Exception e) {
                throw new RuntimeException("Error in read process", e);
            }
        }, executorService);
    }
}

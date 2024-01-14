package com.example.legacyservice.service.interfaces;

import com.example.legacyservice.dto.TvSeriesDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface TvSeriesReaderService {

    CompletableFuture<List<TvSeriesDto>> readTvSeriesAsync(int pageNumber, int metadataType);

    CompletableFuture<List<TvSeriesDto>> getTvSeriesSeasons(List<TvSeriesDto> tvSeriesDtoList);

    CompletableFuture<List<TvSeriesDto>> getTvSeriesSeasonsEpisodes(List<TvSeriesDto> tvSeriesDtoList);
}

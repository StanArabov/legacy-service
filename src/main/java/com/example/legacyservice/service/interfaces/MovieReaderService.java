package com.example.legacyservice.service.interfaces;

import com.example.legacyservice.dto.MovieDto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MovieReaderService {
    CompletableFuture<List<MovieDto>> readMoviesAsync(int pageNumber, int metadataType);

}

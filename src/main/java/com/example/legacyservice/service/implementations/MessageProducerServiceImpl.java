package com.example.legacyservice.service.implementations;

import com.example.legacyservice.repository.MetadataItemsRepository;
import com.example.legacyservice.service.interfaces.MessageProducerService;
import com.example.legacyservice.service.interfaces.MovieReaderService;
import com.example.legacyservice.service.interfaces.TvSeriesReaderService;
import com.example.legacyservice.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;


@Service
@AllArgsConstructor
public class MessageProducerServiceImpl implements MessageProducerService {

    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange direct;
    private final ExecutorService executorService;
    private final MetadataItemsRepository metadataItemsRepository;
    private final ObjectMapper objectMapper;
    private final TvSeriesReaderService tvSeriesReaderService;
    private final MovieReaderService movieReaderService;

    @Override
    public void sendMessage() {
        sendMediaType(Constants.METADATA_TYPE_MOVIE, Constants.MOVIES_PAGE_SIZE, this::readMovies);
        sendMediaType(Constants.METADATA_TYPE_TV_SERIES, Constants.TV_SERIES_PAGE_SIZE, this::readTvSeries);
    }

    @Override
    public <T> CompletableFuture<Void> sendItemsAsync(List<T> list, String routingKey) {
        return CompletableFuture.runAsync(() -> {
            String stringifyList = convertObjectToJsonString(list);
            this.rabbitTemplate.convertAndSend(direct.getName(), routingKey, stringifyList);
        }, executorService);
    }

    private void sendMediaType(int metadataType, int pageSize, Function<Integer, Void> read) {
        Integer totalPages = getTotalPages(metadataType, pageSize);
        int pageNumber = 0;
        while (totalPages != pageNumber) {
            read.apply(pageNumber);
            pageNumber++;
        }
    }


    private Void readMovies(int moviesPageNumber) {
        movieReaderService.readMoviesAsync(moviesPageNumber, Constants.METADATA_TYPE_MOVIE)
                .thenApplyAsync(list -> sendItemsAsync(list, Constants.MOVIE_QUEUE_ROUTING_KEY));
        return null;
    }

    private Void readTvSeries(int tvSeriesPageNumber) {
        tvSeriesReaderService.readTvSeriesAsync(tvSeriesPageNumber, Constants.METADATA_TYPE_TV_SERIES)
                .thenComposeAsync(tvSeriesReaderService::getTvSeriesSeasons)
                .thenComposeAsync(tvSeriesReaderService::getTvSeriesSeasonsEpisodes)
                .thenApplyAsync(list -> sendItemsAsync(list, Constants.TV_SERIES_ROUTING_KEY));
        return null;
    }

    private <T> String convertObjectToJsonString(T item) {
        try {
            return objectMapper.writeValueAsString(item);
        } catch (IOException e) {
            return "";
        }
    }

    private Integer getTotalPages(int metadataType, int pageSize) {
        Integer totalRecords = metadataItemsRepository.getMoviesCount(metadataType);
        System.out.println(totalRecords);
        return (int) Math.ceil((double) totalRecords / pageSize);
    }
}

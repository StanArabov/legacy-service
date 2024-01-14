package com.example.legacyservice.service.implementations;

import com.example.legacyservice.dto.MovieDto;
import com.example.legacyservice.mapper.MediaTypeMapper;
import com.example.legacyservice.repository.MetadataItemsRepository;
import com.example.legacyservice.service.interfaces.MovieReaderService;
import com.example.legacyservice.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
@AllArgsConstructor
public class MovieReaderServiceImpl implements MovieReaderService {
    private final ExecutorService executorService;
    private final MetadataItemsRepository metadataItemsRepository;
    private final MediaTypeMapper mediaTypeMapper;
    @Override
    public CompletableFuture<List<MovieDto>> readMoviesAsync(int pageNumber, int metadataType) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                PageRequest pageable = PageRequest.of(pageNumber, Constants.MOVIES_PAGE_SIZE);
                return mediaTypeMapper.mediaTypeProjectionListToMovieDtoList(
                        metadataItemsRepository.findSelectedMediaType(pageable, metadataType));
            } catch (Exception e) {
                throw new RuntimeException("Error in read process", e);
            }
        }, executorService);
    }
}

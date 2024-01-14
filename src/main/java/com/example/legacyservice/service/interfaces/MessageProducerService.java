package com.example.legacyservice.service.interfaces;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MessageProducerService {
    void sendMessage();

    <T> CompletableFuture<Void> sendItemsAsync(List<T> list, String routingKey);
}

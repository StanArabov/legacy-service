package com.example.legacyservice.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public Queue hello() {
        return new Queue("plex-queue");
    } //todo move the name of the queue
}

package com.example.legacyservice.config;

import com.example.legacyservice.util.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue movieQueue() { return new Queue(Constants.MOVIE_QUEUE);
    }

    @Bean
    public Queue tvSeriesQueue() { return new Queue(Constants.TV_SERIES_QUEUE);
    }

    @Bean
    public DirectExchange direct() {
        return new DirectExchange(Constants.EXCHANGE);
    }

    @Bean
    public Binding bindingMovieQ(DirectExchange direct, Queue movieQueue) {
        return BindingBuilder.bind(movieQueue)
                .to(direct)
                .with(Constants.MOVIE_QUEUE_ROUTING_KEY);
    }

    @Bean
    public Binding bindingTvSeriesQ(DirectExchange direct, Queue tvSeriesQueue) {
        return BindingBuilder.bind(tvSeriesQueue)
                .to(direct)
                .with(Constants.TV_SERIES_ROUTING_KEY);
    }

}

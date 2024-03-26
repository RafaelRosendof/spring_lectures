package com.api_grapql.exemplo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.api_grapql.exemplo.modelo.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

@Configuration
public class SubscriptionConfig {
    @Bean
    public Sinks.Many<User> userSink() {
        return Sinks.many().multicast().onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
    }

    @Bean
    public Flux<User> userFlux(Sinks.Many<User> userSink) {
        return userSink.asFlux();
    }
    
}

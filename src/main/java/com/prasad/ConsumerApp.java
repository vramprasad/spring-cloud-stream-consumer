package com.prasad;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class ConsumerApp {
    private Logger logger = LoggerFactory.getLogger(ConsumerApp.class);
    @StreamListener("input")
    public void consumeMessage(EnrichmentJob enrichmentJob){
        logger.info("Message consumed - " + enrichmentJob.toString());
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }
}

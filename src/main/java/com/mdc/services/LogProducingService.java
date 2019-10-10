package com.mdc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LogProducingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogProducingService.class);

    public void writeSomeLoggingStatements(String message) {
        LOGGER.info("Let's assert some logs! " + message);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> LOGGER.info("This message is in a separate thread"));
        do {
            // wait for future to complete
        } while (!future.isDone());
    }
}

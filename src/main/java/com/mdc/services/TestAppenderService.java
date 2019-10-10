package com.mdc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestAppenderService {

    private static final  Logger LOGGER = LoggerFactory.getLogger(TestAppenderService.class);

    String getMessage() {
        LOGGER.info("The message was returned");
        return "This is my message";
    }
}

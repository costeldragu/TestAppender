package com.mdc.services.testutils;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class TestAppender extends AppenderSkeleton {

    private static final List<String> MESSAGES = new ArrayList<>();


    @Override
    protected void append(LoggingEvent loggingEvent) {
        MESSAGES.add(loggingEvent.getRenderedMessage());
    }

    @Override
    public void close() {
        MESSAGES.clear();
    }

    @Override
    public boolean requiresLayout() {
        return false;
    }

    public static boolean containMessage(String message) {
        Predicate<String> pattern = Pattern.compile(message).asPredicate();
        return MESSAGES.stream().anyMatch(pattern);
    }
}

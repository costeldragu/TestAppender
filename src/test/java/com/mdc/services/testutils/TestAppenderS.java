package com.mdc.services.testutils;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class TestAppenderS  extends AppenderBase<ILoggingEvent> {
    private final static List<String> events = new CopyOnWriteArrayList<>();

    @Override
    public void append(ILoggingEvent logEvent) {
        events.add(logEvent.getFormattedMessage());
    }

    public static boolean containMessage(String message) {
        Predicate<String> pattern = Pattern.compile(message).asPredicate();
        return events.stream().anyMatch(pattern);
    }
}

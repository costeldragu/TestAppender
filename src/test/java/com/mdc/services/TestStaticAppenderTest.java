package com.mdc.services;

import com.mdc.services.testutils.StaticAppender;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@RunWith(SpringRunner.class)

public class TestStaticAppenderTest {
    @Before
    public void clearLoggingStatements() {
        StaticAppender.clearEvents();
    }

    @Test
    public void testAssertingLoggingStatementsA() {
        LogProducingService service = new LogProducingService();
        service.writeSomeLoggingStatements("A");
        assertThat(StaticAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! A",
                "This message is in a separate thread");
    }

    @Test
    public void testAssertingLoggingStatementsB() {
        LogProducingService service = new LogProducingService();
        service.writeSomeLoggingStatements("B");
        assertThat(StaticAppender.getEvents()).extracting("message").containsOnly("Let's assert some logs! B",
                "This message is in a separate thread");
    }
}

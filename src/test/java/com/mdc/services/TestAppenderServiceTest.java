package com.mdc.services;

import com.mdc.services.testutils.TestAppender;
import com.mdc.services.testutils.TestAppenderS;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = {
        "log4j.rootLogger=testAppender",
        "log4j.appender.testAppender=com.mdc.services.testutils.TestAppenderS",
        "log4j.appender.testAppender.Target=System.out"
})
public class TestAppenderServiceTest {

    TestAppenderService testAppenderService = new TestAppenderService();

    @Rule
    public final OutputCapture outputCapture = new OutputCapture();

    @Before
    public void setUp() {
        Logger.getRootLogger().removeAllAppenders();

        Logger.getRootLogger().addAppender(new TestAppender());

    }

    @Test
    public void testMessage() {
        String expected = "This is my message";
        String actual = testAppenderService.getMessage();
        assertEquals(expected,actual);
        outputCapture.expect(containsString("The message was returned"));
        assertTrue(TestAppenderS.containMessage("The message was returned"));
    }
}

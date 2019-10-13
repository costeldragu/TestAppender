package com.mdc.services.integration;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.rule.OutputCapture;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        snippets = SnippetType.CAMELCASE,
        features = "classpath:features")
public class CucumberTest {
    @ClassRule
    public final static OutputCapture outputCapture = new OutputCapture();
}

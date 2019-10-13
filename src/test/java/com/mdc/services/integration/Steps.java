package com.mdc.services.integration;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.BeforeClass;
import org.springframework.boot.web.server.LocalServerPort;

public class Steps {

    private int cunkStart;

    @LocalServerPort
    private int port;

    @BeforeClass
    public void setUp() {
        cunkStart =  CucumberTest.outputCapture.toString().length();

    }

    @When("^the link is accessed$")
    public void theBelowLinkIsAccessed()  {

    }

    @Then("^the message should be in the logs$")
    public void theFollowingMessageShouldPeInThelogs() throws Throwable {

    }


}

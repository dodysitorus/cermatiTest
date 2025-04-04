package org.example.stepDefinitions;

import org.example.utils.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpenWebsiteSteps {
    @Given("[user] opens website using the endpoint {string}")
    public void userOpensWebsiteUsingTheEndpoint(String url) {
        DriverFactory.getDriver().get(url);

    }

    @Then("[user] verify the current url of website contains {string}")
    public void userVerifyTheCurrentUrlOfWebsiteContains(String expectedUrl) {
        String actualUrl = DriverFactory.getDriver().getCurrentUrl();
        System.out.println("Actual Url is: " + actualUrl);
        assertThat("wrong assertion for current url website", actualUrl, containsString(expectedUrl));
    }

}

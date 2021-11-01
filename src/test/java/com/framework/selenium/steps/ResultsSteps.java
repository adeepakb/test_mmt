package com.framework.selenium.steps;

import com.framework.selenium.pages.ResultsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultsSteps {

    @Autowired
    private ResultsPage resultsPage;

    @Then("^the links are displayed on the results page$")
    public void theLinksAreDisplayedOnTheResultsPage() {
        boolean result = resultsPage.isTodaysSearchListDisplayed();
        Assert.assertTrue(result);
    }
}

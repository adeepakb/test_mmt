package com.framework.selenium.steps;

import com.framework.selenium.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class HomeSteps {

    @Autowired
    private HomePage homePage;

    @Given("^I search flight from \"([^\"]*)\" to \"([^\"]*)\" in the search input of the home page$")
    public void iSearchInTheSearchInputOfTheHomePage(String search1,String search2) throws InterruptedException {
        homePage.inputFromSearch(search1);
        homePage.inputToSearch(search2);
        homePage.clickOnTodayDate();
    }

    @When("^I press the search button in the home page$")
    public void iPressTheSearchButtonInTheHomePage() {
        homePage.pressSearchButton();
    }

    @When("^I select \"([^\"]*)\" passangers and \"([^\"]*)\" class")
    public void iPressTheSearhButtonInTheHomePage(String no, String cla) throws Exception {
        homePage.clickOnTravellerData();
        homePage.selectNumberOfAdults(Integer.parseInt(no));
        homePage.selectClass(cla);
        homePage.clickOnApplyButton();
    }
}

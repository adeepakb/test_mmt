package com.framework.selenium.pages;

import com.framework.selenium.helpers.VisibilityHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultsPage implements BasePage {

    private static final String LINKS_AREA_LOCATOR = "#links";

    @Autowired
    private VisibilityHelper visibilityHelper;


    @FindBy(how = How.XPATH,using = "//div[@class='weeklyFareItems active']")
    WebElement flightItemFortoday;


    public boolean isTodaysSearchListDisplayed(){

        boolean flag =false;
        try {
            visibilityHelper.waitForVisibilityOf(flightItemFortoday);
            flag =flightItemFortoday.isDisplayed();
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }
}
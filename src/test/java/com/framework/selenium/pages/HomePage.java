package com.framework.selenium.pages;

import com.framework.selenium.helpers.VisibilityHelper;
import com.framework.selenium.runners.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomePage implements BasePage {

    @Autowired
    private Hook hooks;

    @Autowired
    private VisibilityHelper visibilityHelper;

    @FindBy(how = How.XPATH, using = "//input[contains(@class ,'react-autosuggest__input react-autosuggest__input--open')]")
    private WebElement searchFromInput;


    @FindBy(how = How.ID, using = "fromCity")
    private WebElement searchFromInput1;

    @FindBy(how = How.XPATH, using = "//li[@class= 'react-autosuggest__suggestion react-autosuggest__suggestion--first']")
    private WebElement firstSugestion;


    @FindBy(how = How.XPATH, using = "//div[@class = 'makeFlex column flexOne whiteText latoBold']")
    WebElement login;

    @FindBy(how = How.XPATH,using =  "//div[@class= 'DayPicker-Day DayPicker-Day--today']")
    WebElement todayDate;

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Search')]")
    WebElement searchButton;

    @FindBy(how = How.XPATH,using = "//span[@class='appendRight10']")
    WebElement travellerWidgetButton;

    @FindBy(how = How.XPATH,using = "//button[@data-cy='travellerApplyBtn']")
    WebElement applyButton;

    @FindBy(how = How.XPATH,using = "//div[@class='weeklyFareItems active']")
    WebElement flightItemFortoday;

    public void inputFromSearch(String search) throws InterruptedException {
        Actions actions = new Actions(hooks.getDriver());
        try{

            actions.moveToElement(login).click().perform();
        }catch (ElementClickInterceptedException e){

        }
        WebElement element = hooks.getDriver().findElement(By.xpath("//span[@class ='lbl_input latoBold  appendBottom5']"));
        actions.moveToElement(element).click().perform();
        visibilityHelper.waitForPresenceOf(By.xpath("//input[@class= 'react-autosuggest__input react-autosuggest__input--open']"));
        actions.moveToElement(searchFromInput).click().perform();
        searchFromInput.sendKeys(search);
        Thread.sleep(2000);
        firstSugestion.click();

    }
    public void inputToSearch(String search) throws InterruptedException {
        visibilityHelper.waitForVisibilityOf(searchFromInput);
        searchFromInput.sendKeys(search);
        visibilityHelper.waitForVisibilityOf(firstSugestion);
        visibilityHelper.waitForVisibilityOf(firstSugestion);
        Thread.sleep(2000);
        firstSugestion.click();
    }

    public void pressSearchButton(){
        searchButton.click();
        System.out.println();
    }

    public void clickOnTodayDate(){
        todayDate.click();
    }

    public void clickOnTravellerData() {
        travellerWidgetButton.click();
    }
    public void selectNumberOfAdults(int no) throws Exception {
        if (no<=9 && no>=0){
            hooks.getDriver().findElement(By.xpath("//li[@data-cy='adults-"+no+"']")).click();
        }
        else {
            throw new Exception("Numer should be grater than 0 or less than 9");
        }
    }

    public void selectClass(String cla) throws Exception {
        List<WebElement> webElements = hooks.getDriver().findElements(By.xpath("//li[contains(@data-cy, 'travelClass')]"));
        if (cla.equalsIgnoreCase("Economy")){
            webElements.get(0).click();
        }else if (cla.equalsIgnoreCase("Premium")){
            webElements.get(1).click();
        }else if(cla.equalsIgnoreCase("Business")){
            webElements.get(2).click();
        }else {
            throw new Exception("Nu suh class"+cla);
        }
        System.out.println();
    }

    public void clickOnApplyButton() {
        applyButton.click();
    }


}
package com.automation.pages.flightsreservation;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    public WebDriver driver;

    @FindBy(id = "go-to-flights-search")
    private WebElement goToFlightsSearchButton;

    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    public void clickOnGoToFlightsSearchButton(){
        this.goToFlightsSearchButton.click();
    }

    public boolean isAt(){
        this.wait.until(ExpectedConditions.visibilityOf(this.goToFlightsSearchButton));
        return this.goToFlightsSearchButton.isDisplayed();
    }
}

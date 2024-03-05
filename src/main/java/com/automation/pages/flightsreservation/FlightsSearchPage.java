package com.automation.pages.flightsreservation;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightsSearchPage extends AbstractPage {

    @FindBy(id = "passengers")
    private WebElement passengersDropDownMenu;

    @FindBy(id = "search-flights")
    private WebElement searchFlightsButton;

    public FlightsSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.searchFlightsButton));
        return this.searchFlightsButton.isDisplayed();
    }

    public void selectPassengerCount(String passengerCount){
        Select passengersDropDown = new Select(this.passengersDropDownMenu);
        passengersDropDown.selectByVisibleText(passengerCount);
    }

    public void clickFlightsButton(){
        this.searchFlightsButton.click();
    }
}

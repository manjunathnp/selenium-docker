package com.automation.pages.flightsreservation;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelectionPage extends AbstractPage {

    public FlightSelectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "departure-flight")
    private List<WebElement> departureFlightsOptions;

    @FindBy(name = "arrival-flight")
    private List<WebElement> arrivalFlightsOptions;

    @FindBy(id = "confirm-flights")
    private WebElement confirmFlightsButton;

    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(confirmFlightsButton));
        return confirmFlightsButton.isDisplayed();
    }

    public void selectFlights(){
        int random = ThreadLocalRandom.current().nextInt(0, departureFlightsOptions.size());
        departureFlightsOptions.get(random).click();
        arrivalFlightsOptions.get(random).click();
    }

    public void clickConfirmFlightsButton(){
        //wait.until(ExpectedConditions.elementToBeClickable(confirmFlightsButton)).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirmFlightsButton);
        //confirmFlightsButton.click();

    }
}

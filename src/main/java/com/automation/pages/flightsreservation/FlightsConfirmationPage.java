package com.automation.pages.flightsreservation;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FlightsConfirmationPage extends AbstractPage {
    public FlightsConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[normalize-space()='Congratulations on booking your flight ticket!']")
    private WebElement confirmationMessage;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.
                textToBePresentInElement(confirmationMessage,
                                        "Congratulations on booking your flight ticket!"));

        return true;
    }
}

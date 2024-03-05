package com.automation.pages.flightsreservation;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends AbstractPage {

    @FindBy(id = "firstName")
    private WebElement firstNameTextField;

    @FindBy(id = "lastName")
    private WebElement lastNameTextField;

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(name = "street")
    private WebElement streetTextField;

    @FindBy(name = "city")
    private WebElement cityTextField;

    @FindBy(id = "inputState")
    private WebElement stateDropDownMenu;

    @FindBy(name = "zip")
    private WebElement zipCodeTextField;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver){
        super(driver);

    }

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(this.registerButton));
        return this.registerButton.isDisplayed();
    }

    public void launchApplication(String url){
        this.driver.get(url);
    }

    public void inputUserFullName(String firstName, String lastName){
        this.firstNameTextField.sendKeys(firstName);
        this.lastNameTextField.sendKeys(lastName);
    }

    public void inputUserCredentials(String email, String password){
        this.emailTextField.sendKeys(email);
        this.passwordTextField.sendKeys(password);
    }

    public void inputFullAddress(String street, String city, String state, String zipcode){
        this.streetTextField.sendKeys(street);
        this.cityTextField.sendKeys(city);

        Select selectStateDropDown = new Select(this.stateDropDownMenu);
        selectStateDropDown.selectByVisibleText(state);

        this.zipCodeTextField.sendKeys(zipcode);
    }

    public void clickOnRegisterButton(){
        this.registerButton.click();
    }
}

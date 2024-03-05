package com.automation.pages.vendorportal;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage
{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement usernameTxtFld;

    @FindBy(id = "password")
    private WebElement passwordTxtFld;

    @FindBy(id = "login")
    private WebElement loginButton;

    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this.loginButton.isDisplayed();
    }

    public void goTo(String url){
        this.driver.get(url);
    }
    public void userLogin(String username, String password){
        usernameTxtFld.sendKeys(username);
        passwordTxtFld.sendKeys(password);
        loginButton.click();
    }
}

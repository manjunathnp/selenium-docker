package com.automation.pages.vendorportal;

import com.automation.pages.AbstractPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage{
    private static final Logger log = LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="monthly-earning")
    private WebElement monthlyEarnings;

    @FindBy(id="annual-earning")
    private WebElement annualEarnings;

    @FindBy(id="profit-margin")
    private WebElement profitMargin;

    @FindBy(id="available-inventory")
    private WebElement availableInventory;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchTxtFld;

    @FindBy(id = "dataTable_info")
    private WebElement dataTableInfo;

    @FindBy(id = "userDropdown")
    private WebElement userDropdown;

    @FindBy(css = "a[data-toggle='modal']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    private WebElement logoutButton;



    @Override
    public boolean isAt() {
        this.wait.until(ExpectedConditions.visibilityOf(monthlyEarnings));
        return this.monthlyEarnings.isDisplayed();
    }

    public String getMonthlyEarnings(){
        return this.monthlyEarnings.getText();
    }

    public String getAnnualEarnings(){
        return this.annualEarnings.getText();
    }

    public String getProfitMargin(){
        return this.profitMargin.getText();
    }

    public String getAvailableInventory(){
        return this.availableInventory.getText();
    }

    public void searchOrderHistoryBy(String searchText){
        this.searchTxtFld.sendKeys(searchText);
    }

    public int getSearchResultCount(){
        String resultsText = this.dataTableInfo.getText();
        String[] arr = resultsText.split(" ");
        int searchCount = Integer.parseInt(arr[5]);
        log.info("Search Results Count = {}", searchCount);
        return searchCount;
    }

    public void userLogout(){
        this.userDropdown.click();
        this.wait.until(ExpectedConditions.visibilityOf(logoutLink)).click();
        this.wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }
}

package com.automation.tests.vendorportal;

import com.automation.pages.vendorportal.DashboardPage;
import com.automation.pages.vendorportal.LoginPage;
import com.automation.tests.AbstractTest;
import com.automation.tests.vendorportal.model.VendorPortalTestData;
import com.automation.utilities.JSonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VendorPortalTest extends AbstractTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData vendorPortalTestData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath){
        this.loginPage=new LoginPage(driver);
        this.dashboardPage=new DashboardPage(driver);
        this.vendorPortalTestData= JSonUtils.getTestData(testDataPath, VendorPortalTestData.class);
    }
    @Test
    public void userLogin(){
        loginPage.goTo("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.userLogin(vendorPortalTestData.username(), vendorPortalTestData.password());
    }

    @Test(dependsOnMethods = "userLogin")
    public void dashboardValidation(){
        Assert.assertTrue(dashboardPage.isAt());

        Assert.assertEquals(dashboardPage.getMonthlyEarnings(), vendorPortalTestData.monthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarnings(), vendorPortalTestData.annualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(), vendorPortalTestData.profitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), vendorPortalTestData.availableInventory());

        dashboardPage.searchOrderHistoryBy(vendorPortalTestData.searchKeyword());
        Assert.assertEquals(dashboardPage.getSearchResultCount(), vendorPortalTestData.searchResultsCount());
    }

    @Test(dependsOnMethods = "dashboardValidation")
    public void userLogout(){
        dashboardPage.userLogout();
        Assert.assertTrue(loginPage.isAt());
    }
}

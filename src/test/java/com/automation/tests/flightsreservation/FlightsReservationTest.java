package com.automation.tests.flightsreservation;

import com.automation.pages.flightsreservation.*;
import com.automation.tests.AbstractTest;
import com.automation.tests.flightsreservation.model.FlightReservationTestData;
import com.automation.utilities.JSonUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightsReservationTest extends AbstractTest {
    private String passengerCount;
    private RegistrationPage registrationPage;
    private RegistrationConfirmationPage registrationConfirmationPage;
    private FlightsSearchPage flightsSearchPage;
    private FlightSelectionPage flightSelectionPage;
    private FlightsConfirmationPage flightsConfirmationPage;
    private FlightReservationTestData flightReservationTestData;

    @BeforeTest
    @Parameters("testDataPath")
    public void setPageObject(String testDataPath){
        this.registrationPage=new RegistrationPage(driver);
        this.registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        this.flightsSearchPage=new FlightsSearchPage(driver);
        this.flightSelectionPage=new FlightSelectionPage(driver);
        this.flightsConfirmationPage=new FlightsConfirmationPage(driver);

        this.flightReservationTestData= JSonUtils.getTestData(testDataPath, FlightReservationTestData.class);

    }

    @Test(priority = 0)
    public void userRegistrationTest(){
        //RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.launchApplication("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.inputUserFullName(flightReservationTestData.firstName(), flightReservationTestData.lastName());
        registrationPage.inputUserCredentials(flightReservationTestData.email(), flightReservationTestData.password());
        registrationPage.inputFullAddress(flightReservationTestData.street(), flightReservationTestData.city(), flightReservationTestData.state(), flightReservationTestData.zip());
        registrationPage.clickOnRegisterButton();
    }

    @Test(priority = 1)
    public void userRegistrationConfirmationTest(){
        //RegistrationConfirmationPage registrationConfirmationPage=new RegistrationConfirmationPage(driver);
        Assert.assertTrue(registrationConfirmationPage.isAt());
        registrationConfirmationPage.clickOnGoToFlightsSearchButton();
    }

    @Test(priority = 2)
    public void flightsSearchTest(){
        //FlightsSearchPage flightsSearchPage=new FlightsSearchPage(driver);
        Assert.assertTrue(flightsSearchPage.isAt());
        flightsSearchPage.selectPassengerCount(flightReservationTestData.passengerCount());
        flightsSearchPage.clickFlightsButton();
    }

    @Test(priority = 3)
    public void flightsSelectionTest(){
        //FlightSelectionPage flightSelectionPage=new FlightSelectionPage(driver);
        Assert.assertTrue(flightSelectionPage.isAt());
        flightSelectionPage.selectFlights();
        //Thread.sleep(5000);
        flightSelectionPage.clickConfirmFlightsButton();
    }

    @Test(priority = 4)
    public void flightsConfirmationTest(){
        //FlightsConfirmationPage flightsConfirmationPage=new FlightsConfirmationPage(driver);
        Assert.assertTrue(flightsConfirmationPage.isAt());

    }
}

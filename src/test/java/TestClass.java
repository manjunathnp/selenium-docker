import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestClass {
    WebDriver driver;


    //@Test
    public void validatePrice() throws InterruptedException {

        driver=new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("register-btn")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("go-to-flights-search")))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("search-flights")))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("confirm-flights")))).click();
        Thread.sleep(2000);
        WebElement ele1 = driver.findElement(By.xpath("//*[@id=\"flights-confirmation-section\"]/div/div/div/form/div/div/div[3]/div[2]/p"));
        String price = ele1.getText();

        System.out.println("Price: "+price);

    }
}

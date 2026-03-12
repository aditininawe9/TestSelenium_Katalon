package com.testingacademy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Booking {
    @Test
    public void testBooking() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.booking.com");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Dismiss sign in information.']")));
        closeButton.click();

        WebElement flights = driver.findElement(By.id("flights"));
        flights.click();

        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement leavingTo = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-ui-name='input_location_to_segment_0']")));
        Actions actions = new Actions(driver);
        actions.moveToElement(leavingTo)
                .click().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
                .perform();
    }
}

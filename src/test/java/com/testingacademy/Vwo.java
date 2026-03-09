package com.testingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Vwo {
    @Test
    public void testVWO() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        WebElement email = driver.findElement(By.cssSelector("#login-username"));
        email.sendKeys("admin");

        WebElement password = driver.findElement(By.cssSelector("#login-password"));
        password.sendKeys("admin");

        WebElement submit = driver.findElement(By.cssSelector("#js-login-btn"));
        submit.click();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#js-notification-box")));

    }

}

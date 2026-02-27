package com.testingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Katalon {
    @Test
    public void TestKatalon() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        //driver.findElement(By.id("login-username"));
        WebElement MakeAppointmentBtn = driver.findElement(By.linkText("Make Appointment"));
        MakeAppointmentBtn.click();

        WebElement userNameInput = driver.findElement(By.id("txt-username"));
        userNameInput.sendKeys("John Doe");

        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys("ThisIsNotAPassword");

        Thread.sleep(500);

        WebElement loginBtn = driver.findElement(By.id("btn-login"));
        loginBtn.click();

        Thread.sleep(5000);

//        WebElement errorMsg = driver.findElement(By.className("text-danger"));
//        errorMsg.getText();

        //Assertions
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
    }
}

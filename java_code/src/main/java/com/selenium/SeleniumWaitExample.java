package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class SeleniumWaitExample {

    private WebDriver driver;
    private final String TEST_URL = "https://the-internet.herokuapp.com/dynamic_loading/1";
    private final String TEST_URL_FLUENT = "https://the-internet.herokuapp.com/dynamic_loading/2";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your chromedriver path
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testImplicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait

        driver.get(TEST_URL);
        driver.findElement(By.cssSelector("#start button")).click();

        WebElement finishText = driver.findElement(By.id("finish"));
        assertTrue(finishText.isDisplayed());
        assertEquals(finishText.getText(), "Hello World!");
    }

    @Test
    public void testExplicitWait() {
        driver.get(TEST_URL);
        driver.findElement(By.cssSelector("#start button")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10); // Explicit wait
        WebElement finishText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        assertTrue(finishText.isDisplayed());
        assertEquals(finishText.getText(), "Hello World!");
    }

    @Test
    public void testFluentWait() {
        driver.get(TEST_URL_FLUENT);
        driver.findElement(By.cssSelector("#start button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        WebElement finishText = wait.until(d -> d.findElement(By.id("finish")));

        assertTrue(finishText.isDisplayed());
        assertEquals(finishText.getText(), "Hello World!");
    }
}
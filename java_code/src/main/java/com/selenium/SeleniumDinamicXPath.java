package com.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SeleniumDinamicXPath {
    //private WebDriver driver;
    //private WebDriverWait wait;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Replace with your ChromeDriver path
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait; // Adjust timeout as needed
        wait = new WebDriverWait(driver, 10);
        try {
            driver.get("https://www.example.com"); // Replace with your URL
            String basePath = "//a[contains(@href, '%s')]";
            String dynamicValue = "example"; // Replace with your dynamic value
            String dynamicXPath = String.format(basePath, dynamicValue);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(dynamicXPath)));//EXPLICIT WAIT
            if (element != null) {
                element.click(); // Assertions
                Assertions.assertTrue(driver.getCurrentUrl().contains(dynamicValue), "URL should contain dynamic value");
                Assertions.assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Example Domain"), "Header should contain Example Domain");
                Assertions.assertTrue(driver.findElement(By.className("some-class")).isDisplayed(), "Element with class 'some-class' should be visible");
            } else {
                System.out.println("Element not found.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
            Assertions.fail("An exception occurred during test execution: " + e.getMessage());
        }
    }
}
package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumiFrames {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Replace with your ChromeDriver path
        driver = new ChromeDriver();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/iframe");
        By frameLocator = By.id("mce_0_ifr");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(frameLocator));
        By dismissButton = By.xpath("//button[@class='tox-notification__dismiss tox-button tox-button--naked tox-button--icon']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dismissButton));
        driver.findElement(dismissButton).click();
        driver.switchTo().frame("mce_0_ifr");
        String textInFrame = driver.findElement(By.id("tinymce")).getText();
        System.out.println(textInFrame);
        driver.switchTo().defaultContent();
        String textInMainframe = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
        System.out.println(textInMainframe);
    }
}
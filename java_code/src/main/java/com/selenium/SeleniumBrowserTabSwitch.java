package com.selenium;//Switch Tabs
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class SeleniumBrowserTabSwitch {
    public static void main(String[] args) { // Set up the WebDriver (assuming you have the chromedriver executable in your PATH)
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");// Open the first tab and navigate to a URL
        System.out.println("First Tab Title: " + driver.getTitle());
        // Open a new tab by executing JavaScript
        ((JavascriptExecutor) driver).executeScript("window.open()"); //Or click somewhere that opens a new tab
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        driver.switchTo().window(tabs.get(1)); // Switch to the new tab (second tab)
        driver.get("https://www.google.com"); // Navigate to another URL in the new tab
        System.out.println("Second Tab Title: " + driver.getTitle());

        driver.switchTo().window(tabs.get(0));// Switch back to the first tab
        System.out.println("Back to First Tab Title: " + driver.getTitle());

        driver.quit();// Close the browser
    }
}

package com.selenium;

import org.openqa.selenium.JavascriptExecutor;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSlowScroll_JScript {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com"); // Replace with your URL
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll slowly using JavaScript
        int scrollStep = 10; // Adjust the scroll step for speed
        long scrollDelay = 50; // Adjust the delay for smoothness (milliseconds)
        long scrollHeight = (long) js.executeScript("return document.body.scrollHeight");
        long currentPosition = 0;

        while (currentPosition < scrollHeight) {
            js.executeScript("window.scrollBy(0, " + scrollStep + ")");
            currentPosition += scrollStep;
            Thread.sleep(scrollDelay);
        }

        // Scroll back to the top (optional)
        currentPosition = scrollHeight;
        while(currentPosition > 0){
            js.executeScript("window.scrollBy(0, -" + scrollStep + ")");
            currentPosition -= scrollStep;
            Thread.sleep(scrollDelay);
        }
        driver.quit();
    }
}
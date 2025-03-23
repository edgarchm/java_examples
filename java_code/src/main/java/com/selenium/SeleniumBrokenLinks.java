package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SeleniumBrokenLinks {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");         // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup(); //updates and sets up chromedriver
        WebDriver driver = new ChromeDriver();// Create a new instance of the Chrome driver
        driver.get("http://example.com");
        List<WebElement> links = driver.findElements(By.tagName("a")); // Find all links on the webpage
        for (WebElement link : links) { // Check each link
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {
                try { //optional
                    HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                    connection.setRequestMethod("HEAD");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println("Broken link: " + url);
                    } else {
                        System.out.println("Valid link: " + url);
                    }
                } catch (Exception e) { //optional
                    System.out.println("Exception for URL: " + url + " -> " + e.getMessage());
                }
            } else { System.out.println("Invalid URL: " + url); } //Optional
        }//close browser...
    }
}

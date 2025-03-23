package com.selenium;

import org.openqa.selenium.WebDriver; //Basic Selenium script
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class SeleniumBasic {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");         // Set the path to the ChromeDriver executable
        WebDriver driver = new ChromeDriver();// Create a new instance of the Chrome driver
        try{
            driver.get("https://www.example.com"); // Navigate to a web page
            driver.findElement(By.name("q")).sendKeys("Selenium WebDriver"); // Find an element by its name attribute and send text to it
            driver.findElement(By.name("q")).submit();
        }catch(Exception e){
                
        }
            
        // Close the browser
        driver.quit();
    }
}



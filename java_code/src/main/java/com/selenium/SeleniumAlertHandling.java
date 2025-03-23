package com.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlertHandling {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Replace with your path
        WebDriver driver = new ChromeDriver();
        driver.get("your_test_page_url"); // Replace with your test URL

        // Example 1: Simple Alert (OK button)
        driver.findElement(By.id("simpleAlert")).click(); // Locate button to trigger alert
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        simpleAlert.accept(); // Click OK

        // Example 2: Confirmation Alert (OK/Cancel buttons)
        driver.findElement(By.id("confirmAlert")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
        confirmAlert.dismiss(); // Click Cancel (or confirmAlert.accept() for OK)

        // Example 3: Prompt Alert (Text input)
        driver.findElement(By.id("promptAlert")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys("Your Input");
        promptAlert.accept(); // Click OK

        Thread.sleep(2000); // Add a small wait to see the result (optional)
        driver.quit();
    }
}
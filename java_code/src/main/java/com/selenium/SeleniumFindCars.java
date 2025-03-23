package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Or other browser driver
public class SeleniumFindCars {
    public static boolean checkForFerrari(WebDriver driver) {
        try { // Find all elements with the class 'car_brand' and check each element's text.
            java.util.List<WebElement> carBrands = driver.findElements(By.xpath("//li[@class='car_brand']"));
            for (WebElement brandElement : carBrands) {
                if (brandElement.getText().trim().equals("Ferrari")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace(); // Handle exceptions appropriately in your real code
            return false; // Or throw the exception if you prefer
        }
    }
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Replace with your ChromeDriver path
        WebDriver driver = new ChromeDriver();
        driver.get("your_web_page_url");
        boolean hasFerrari = checkForFerrari(driver);
        System.out.println("Has Ferrari: " + hasFerrari);
        driver.quit();
    }
}